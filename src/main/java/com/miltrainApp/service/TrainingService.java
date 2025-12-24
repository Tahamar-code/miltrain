package com.miltrainApp.service;

import com.miltrainApp.exceptions.TrainingNotFoundException;
import com.miltrainApp.entity.model.Training;
import com.miltrainApp.entity.model.TrainingSet;
import com.miltrainApp.repository.TrainingRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TrainingService {

    private final TrainingRepository trainingRepository;


    public TrainingService(TrainingRepository trainingRepository) {
        this.trainingRepository = trainingRepository;
    }

    public Training createTraining(Training newTraining) {
        trainingRepository.save(newTraining);
        return newTraining;
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


