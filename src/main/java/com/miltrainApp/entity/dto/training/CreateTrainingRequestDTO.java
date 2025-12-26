package com.miltrainApp.entity.dto.training;


import com.miltrainApp.utils.ExerciseType;
import lombok.Data;

@Data
public class CreateTrainingRequestDTO {

    private ExerciseType exerciseType;
}
