package com.miltrainApp.exersize;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class Training {

    private final Long userId;

    private final Long trainingId;

    private final ExerciseType exerciseType;

    private final List<Integer> sets = new ArrayList<>(3);

    public void addSet(int reps) {
        if (sets.size() >= 3) {
            throw new IllegalStateException("Max sets is 3!");
        }
        sets.add(reps);
    }

    public int getTotalReps() {
        return sets.stream()
                   .mapToInt(x -> x)
                   .sum();
    }

    public List<Integer> getSets() {
        return List.copyOf(sets);
    }
}
