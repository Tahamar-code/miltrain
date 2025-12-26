package com.miltrainApp.service;

import com.miltrainApp.entity.dto.training.CreateTrainingRequestDTO;
import com.miltrainApp.entity.model.Training;
import com.miltrainApp.entity.model.TrainingSet;
import com.miltrainApp.entity.model.User;
import com.miltrainApp.exceptions.TrainingNotFoundException;
import com.miltrainApp.exceptions.UserNotFoundException;
import com.miltrainApp.repository.TrainingRepository;
import com.miltrainApp.repository.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TrainingService {

    private final UserRepository userRepository;


    private final TrainingRepository trainingRepository;


    public TrainingService(UserRepository userRepository, TrainingRepository trainingRepository) {
        this.userRepository = userRepository;
        this.trainingRepository = trainingRepository;
    }


    private String getCurrentLogin() {
        Authentication auth = SecurityContextHolder.getContext()
                                                   .getAuthentication();
        return auth.getName();
    }


    @PreAuthorize("hasRole('USER')")
    public Training createTraining(CreateTrainingRequestDTO createTrainingRequest) {

        String login = getCurrentLogin();

        User user = userRepository.findByLogin(login)
                                  .orElseThrow(() -> new UserNotFoundException("User not found"));

        Long userId = user.getId();

        Training training = new Training(userId, createTrainingRequest.getExerciseType());

        return trainingRepository.save(training);
    }

    public Training getTrainingById(Long trainingId) {
        return trainingRepository.findById(trainingId)
                                 .orElseThrow(() -> new TrainingNotFoundException("Training not found!"));
    }


    public List<Training> getAllTrainingsByUser(Long userId) {
        return trainingRepository.findAllByUserId(userId);
    }

    public void deleteTrainingById(Long trainingIdForDelete) {
        Training training = trainingRepository.findById(trainingIdForDelete)
                                              .orElseThrow(() -> new TrainingNotFoundException("Training not found!"));
        trainingRepository.deleteById(trainingIdForDelete);
    }

    public void addSetToTraining(Long trainingId, Integer reps) {
        Training training = getTrainingById(trainingId);

        TrainingSet set = new TrainingSet();
        set.setReps(reps);

        training.addSet(set);
        trainingRepository.save(training);
    }
}


