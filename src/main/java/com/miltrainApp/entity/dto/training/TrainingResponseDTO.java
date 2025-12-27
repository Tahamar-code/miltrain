package com.miltrainApp.entity.dto.training;

import com.miltrainApp.entity.model.TrainingSet;
import com.miltrainApp.utils.ExerciseType;
import lombok.Data;

import java.util.List;

@Data
public class TrainingResponseDTO {

    private Long trainingId;

    private Long userId;

    private ExerciseType exerciseType;

    private List<TrainingSet> sets;

    public TrainingResponseDTO() {
    }

    public Builder builder() {
        return new Builder();
    }


    public static class Builder {

        private final TrainingResponseDTO dto = new TrainingResponseDTO();


        public Builder trainingId(Long trainingId){
            dto.trainingId = trainingId;
            return this;
        }

        public Builder userId(Long userId) {
            dto.userId = userId;
            return this;
        }

        public Builder exercise(ExerciseType exerciseType) {
            dto.exerciseType = exerciseType;
            return this;
        }


        public Builder sets(List<TrainingSet> sets){
            dto.sets = sets;
            return this;
        }

        public TrainingResponseDTO build() {
            return dto;
        }
    }
}
