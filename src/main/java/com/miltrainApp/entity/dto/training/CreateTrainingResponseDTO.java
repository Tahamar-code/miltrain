package com.miltrainApp.entity.dto.training;

import com.miltrainApp.utils.ExerciseType;
import lombok.Data;

@Data
public class CreateTrainingResponseDTO {

    private Long userId;

    private ExerciseType exerciseType;

    CreateTrainingResponseDTO() {
    }

    public static Builder builder() {
        return new Builder();
    }


    public static class Builder {

        private final CreateTrainingResponseDTO dto = new CreateTrainingResponseDTO();

        public Builder userId(Long userId) {
            dto.userId = userId;
            return this;
        }

        public Builder exercise(ExerciseType exerciseType) {
            dto.exerciseType = exerciseType;
            return this;
        }

        public CreateTrainingResponseDTO build() {
            return dto;
        }
    }
}
