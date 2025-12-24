package com.miltrainApp.api.controller;


import com.miltrainApp.service.TrainingService;
import com.miltrainApp.entity.model.DeleteResponse;
import com.miltrainApp.entity.model.Training;
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
    public Training createTraining(@RequestBody Training newTraining){
        trainingService.createTraining(newTraining);
        return trainingService.getTrainingById(newTraining.getTrainingId());
    }

    @PostMapping("/{trainingId}/sets")
    public Training addSet(@PathVariable Long trainingId, @RequestParam Integer reps){
        trainingService.addSetToTraining(trainingId, reps);
        return trainingService.getTrainingById(trainingId);
    }

    @GetMapping("/{id}")
    public Training getTrainingById(@PathVariable("id") Long trainingId) {
        return trainingService.getTrainingById(trainingId);
    }

    @GetMapping("/user/{userId}")
    public List<Training> getAllTrainingsByUserId(@PathVariable Long userId){
        return trainingService.getAllTrainingsByUser(userId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteResponse> deleteTrainingById(@PathVariable("id") Long trainingId){
        trainingService.deleteTrainingById(trainingId);
        DeleteResponse deleteResponse = new DeleteResponse(String.format("Training with id:%d is deleted!",
                                                                         trainingId));
        return ResponseEntity.ok(deleteResponse);
    }
}
