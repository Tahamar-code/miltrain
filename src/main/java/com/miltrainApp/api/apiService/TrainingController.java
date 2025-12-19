package com.miltrainApp.api.apiService;


import com.miltrainApp.api.service.TrainingService;
import com.miltrainApp.model.Training;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/trainings")
public class TrainingController {

    @PostMapping
    public void createTraining(@RequestBody Training newTraining){
        TrainingService.createTraining(newTraining);
    }

    @PostMapping("/{trainingId}/sets")
    public void addSet(@PathVariable Long trainingId, @RequestParam Integer reps){
        TrainingService.addSetToTraining(trainingId, reps);
    }

    @GetMapping("/{id}")
    public Training getTrainingById(@PathVariable("id") Long trainingId) {
        return TrainingService.getTrainingById(trainingId);
    }

    @GetMapping("/user/{userId}")
    public List<Training> getAllTrainingsByUserId(@PathVariable UUID userId){
        return TrainingService.getAllTrainingsByUser(userId);
    }

    @DeleteMapping("/{id}")
    public void deleteTrainingById(@PathVariable Long id){
        TrainingService.deleteTrainingById(id);
    }
}
