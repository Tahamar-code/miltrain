package com.miltrainApp.api.controller;


import com.miltrainApp.entity.dto.training.CreateTrainingRequestDTO;
import com.miltrainApp.entity.model.DeleteResponse;
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
    public ResponseEntity<Training> createTraining(@RequestBody CreateTrainingRequestDTO dto) {

        Training training = trainingService.createTraining(dto);
        return ResponseEntity.ok(training);
    }

    @PostMapping("/{trainingId}/sets")
    public Training addSet(@PathVariable Long trainingId, @RequestParam Integer reps) {
        trainingService.addSetToTraining(trainingId, reps);
        return trainingService.getTrainingById(trainingId);
    }

    @GetMapping("/{id}")
    public Training getTrainingById(@PathVariable("id") Long trainingId) {
        return trainingService.getTrainingById(trainingId);
    }

    @GetMapping("/user")
    public List<Training> getAllTrainingsByUserId() {
        return trainingService.getAllTrainingsByUser();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteResponse> deleteTrainingById(@PathVariable("id") Long trainingId) {
        trainingService.deleteTrainingById(trainingId);
        DeleteResponse deleteResponse = new DeleteResponse(String.format("Training with id:%d is deleted!",
                                                                         trainingId));
        return ResponseEntity.ok(deleteResponse);
    }
}
