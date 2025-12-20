package com.miltrainApp.model;


import com.miltrainApp.exceptions.TrainingMaxSetLimitException;
import com.miltrainApp.utils.ExerciseType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Getter
@Setter
public class Training {

    private static final AtomicLong trainingIdCounter = new AtomicLong(0);

    private final Long userId;

    private final List<Integer> sets = new ArrayList<>(3);

    private Long trainingId;

    @Setter
    private ExerciseType exerciseType;

    private Integer totalReps;

    public Training(Long userId, ExerciseType exerciseType) {
        this.userId = userId;
        this.trainingId = generateTrainingId();
        this.exerciseType = exerciseType;
    }

    public static long generateTrainingId() {
        return trainingIdCounter.incrementAndGet();
    }

    public void addSet(int reps) {
        if (sets.size() >= 3) {
            throw new TrainingMaxSetLimitException("Max sets is 3!");
        }
        sets.add(reps);
    }

    public Integer getTotalReps() {
        return sets.stream()
                   .mapToInt(x -> x)
                   .sum();
    }

    public List<Integer> getSets() {
        return List.copyOf(sets);
    }
}
