package com.miltrainApp.api.controller;


import com.miltrainApp.entity.dto.training.CreateTrainingRequestDTO;
import com.miltrainApp.entity.dto.training.TrainingResponseDTO;
import com.miltrainApp.entity.dto.training.DeleteResponseDTO;
import com.miltrainApp.entity.model.Training;
import com.miltrainApp.service.TrainingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainings")
public class TrainingController {

    TrainingService trainingService;

    public TrainingController(TrainingService trainingService) {
        this.trainingService = trainingService;
    }

    @PostMapping
    public ResponseEntity<TrainingResponseDTO> createTraining(@RequestBody CreateTrainingRequestDTO request) {

        TrainingResponseDTO training = trainingService.createTraining(request);
        return ResponseEntity.ok(training);
    }

    @PostMapping("/{trainingId}/sets")
    public TrainingResponseDTO addSet(@PathVariable Long trainingId, @RequestParam Integer reps) {
        trainingService.addSetToTraining(trainingId, reps);
        return trainingService.getTrainingById(trainingId);
    }

    @GetMapping("/{id}")
    public TrainingResponseDTO getTrainingById(@PathVariable("id") Long trainingId) {
        return trainingService.getTrainingById(trainingId);
    }

    @GetMapping("/user")
    public List<Training> getAllTrainingsByUserId() {
        return trainingService.getAllTrainingsByUser();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteResponseDTO> deleteTrainingById(@PathVariable("id") Long trainingId) {
        trainingService.deleteTrainingById(trainingId);
        DeleteResponseDTO deleteResponseDTO = new DeleteResponseDTO(String.format("Training with id:%d is deleted!",
                                                                                  trainingId));
        return ResponseEntity.ok(deleteResponseDTO);
    }
}
