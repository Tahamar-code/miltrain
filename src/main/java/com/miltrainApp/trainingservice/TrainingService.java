package com.miltrainApp.trainingservice;

import com.miltrainApp.exersize.Training;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrainingService {
    private final Map<Long, Training> trainings = new HashMap<>();


    public void createTraining(Training training){
        trainings.put(training.getTrainingId(),training);
    }

    public Training getTrainingById(Long trainingId) {
        return trainings.get(trainingId);
    }

    public List<Training> getAllTrainingsByUser(Long userId){
        return trainings.values().stream().filter(t -> t.getUserId().equals(userId)).toList();
    }
}
