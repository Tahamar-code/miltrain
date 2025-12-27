package com.miltrainApp.service.impl;

import com.miltrainApp.entity.dto.training.CreateTrainingRequestDTO;
import com.miltrainApp.entity.model.Training;
import com.miltrainApp.entity.model.TrainingSet;
import com.miltrainApp.entity.model.User;
import com.miltrainApp.exceptions.TrainingNotFoundException;
import com.miltrainApp.exceptions.UserNotFoundException;
import com.miltrainApp.repository.TrainingRepository;
import com.miltrainApp.repository.UserRepository;
import com.miltrainApp.service.TrainingService;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TrainingServiceImpl implements TrainingService {

    private final UserRepository userRepository;

    private final TrainingRepository trainingRepository;

    public TrainingServiceImpl(UserRepository userRepository, TrainingRepository trainingRepository) {
        this.userRepository = userRepository;
        this.trainingRepository = trainingRepository;
    }

    @Override
    public String getCurrentLogin() {
        Authentication auth = SecurityContextHolder.getContext()
                                                   .getAuthentication();
        return auth.getName();
    }

    public Long getCurrentUserId() {
        String login = getCurrentLogin();
        return userRepository.findByLogin(login)
                             .orElseThrow(() -> new UserNotFoundException("User not found"))
                             .getId();
    }

    @Override
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Training createTraining(CreateTrainingRequestDTO createTrainingRequest) {

        String login = getCurrentLogin();

        User user = userRepository.findByLogin(login)
                                  .orElseThrow(() -> new UserNotFoundException("User not found"));

        Long userId = user.getId();

        Training training = new Training(userId, createTrainingRequest.getExerciseType());

        return trainingRepository.save(training);
    }

    @Override
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public Training getTrainingById(Long trainingId) {

        Training training = trainingRepository.findById(trainingId)
                                              .orElseThrow(() -> new TrainingNotFoundException("Training not found!"));
        Authentication auth = SecurityContextHolder.getContext()
                                                   .getAuthentication();

        boolean isUser = auth.getAuthorities()
                             .stream()
                             .anyMatch(a -> a.getAuthority()
                                             .equals("ROLE_USER"));

        if (isUser && !training.getUserId()
                               .equals(getCurrentUserId())) {
            throw new AccessDeniedException("You can only access your on trainings!");
        }
        return training;
    }

    @Override
    @PreAuthorize("hasRole('USER')")
    public List<Training> getAllTrainingsByUser() {
        Long userId = getCurrentUserId();
        return trainingRepository.findAllByUserId(userId);
    }

    @Override
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void deleteTrainingById(Long trainingIdForDelete) {
        Training training = trainingRepository.findById(trainingIdForDelete)
                                              .orElseThrow(() -> new TrainingNotFoundException("Training not found!"));

        Authentication auth = SecurityContextHolder.getContext()
                                                   .getAuthentication();

        boolean isUser = auth.getAuthorities()
                             .stream()
                             .anyMatch(a -> a.getAuthority()
                                             .equals("ROLE_USER"));

        if (isUser && !training.getUserId()
                               .equals(getCurrentUserId())) {
            throw new AccessDeniedException("You can only access your own trainings!");
        }

        trainingRepository.deleteById(trainingIdForDelete);
    }

    @Override
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public void addSetToTraining(Long trainingId, Integer reps) {
        Training training = getTrainingById(trainingId);

        TrainingSet set = new TrainingSet();
        set.setReps(reps);

        training.addSet(set);
        trainingRepository.save(training);
    }
}


