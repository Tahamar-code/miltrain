package com.miltrainApp.api.entityService;

import com.miltrainApp.exceptions.TrainingNotFoundException;
import com.miltrainApp.model.Training;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TrainingService {

    private final Map<Long, Training> trainings = new HashMap<>();


    public Training createTraining(Training newTraining) {
        trainings.put(newTraining.getTrainingId(), newTraining);
        return newTraining;
    }

    public Training getTrainingById(Long trainingId) {
        if (trainings.containsKey(trainingId)) {
            return trainings.get(trainingId);
        } else {
            throw new TrainingNotFoundException("Training not found!");
        }
    }

    public List<Training> getAllTrainingsByUser(Long userId) {
        return trainings.values()
                        .stream()
                        .filter(t -> t.getUserId()
                                      .equals(userId))
                        .toList();
    }

    public void deleteTrainingById(Long trainingId) {
        if (trainings.containsKey(trainingId)) {
            trainings.remove(trainingId);
        } else {
            throw new TrainingNotFoundException("Training not found!");
        }
    }

    public void addSetToTraining(Long trainingId, Integer reps) {
        Training training = getTrainingById(trainingId);
        if (training == null) {
            throw new TrainingNotFoundException("Training not found!");
        } else {
            training.addSet(reps);
        }
    }
}
