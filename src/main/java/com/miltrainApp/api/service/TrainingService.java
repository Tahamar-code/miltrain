package com.miltrainApp.api.service;

import com.miltrainApp.exceptions.TrainingNotFoundException;
import com.miltrainApp.model.Training;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class TrainingService {

    private static final Map<Long, Training> trainings = new HashMap<>();

    public static void createTraining(Training training) {
        trainings.put(training.getTrainingId(), training);
    }

    public static Training getTrainingById(Long trainingId) {
        return trainings.get(trainingId);
    }

    public static List<Training> getAllTrainingsByUser(UUID userId) {
        return trainings.values()
                        .stream()
                        .filter(t -> t.getUserId()
                                      .equals(userId))
                        .toList();
    }

    public static void deleteTrainingById(Long trainingId) {
        if (trainings.containsKey(trainingId)) {
            trainings.remove(trainingId);
        } else {
            throw new TrainingNotFoundException("Training not found!");
        }
    }

    public static void addSetToTraining(Long trainingId, Integer reps) {
        Training training = getTrainingById(trainingId);
        if (training == null){
            throw new TrainingNotFoundException("Training not found!");
        }else {
            training.addSet(reps);
        }
    }
}
