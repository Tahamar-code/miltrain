package com.miltrainApp.service;

import com.miltrainApp.entity.dto.training.CreateTrainingRequestDTO;
import com.miltrainApp.entity.dto.training.TrainingResponseDTO;
import com.miltrainApp.entity.model.Training;

import java.util.List;

public interface TrainingService {

    String getCurrentLogin();

    TrainingResponseDTO createTraining(CreateTrainingRequestDTO createTrainingRequest);

    TrainingResponseDTO getTrainingById(Long trainingId);

    List<Training> getAllTrainingsByUser();

    void deleteTrainingById(Long trainingIdForDelete);

    TrainingResponseDTO addSetToTraining(Long trainingId, Integer reps);
}
