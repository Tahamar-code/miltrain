package com.miltrainApp.service;

import com.miltrainApp.entity.dto.training.CreateTrainingRequestDTO;
import com.miltrainApp.entity.model.Training;

import java.util.List;

public interface TrainingService {

    String getCurrentLogin();

    Training createTraining(CreateTrainingRequestDTO createTrainingRequest);

    Training getTrainingById(Long trainingId);

    List<Training> getAllTrainingsByUser();

    void deleteTrainingById(Long trainingIdForDelete);

    void addSetToTraining(Long trainingId, Integer reps);
}
