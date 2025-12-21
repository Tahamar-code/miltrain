package com.miltrainApp.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.miltrainApp.exceptions.TrainingMaxSetLimitException;
import com.miltrainApp.utils.ExerciseType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "trainings")
@Getter
@Setter
@NoArgsConstructor
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainingId;

    private Long userId;

    private ExerciseType exerciseType;

    @JsonManagedReference
    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<TrainingSet> sets = new ArrayList<>(3);

    public Training(Long userId, ExerciseType exerciseType) {
        this.userId = userId;
        this.exerciseType = exerciseType;
    }


    public void addSet(TrainingSet newSet) {
        if (sets.size() >= 3) {
            throw new TrainingMaxSetLimitException("Max sets is 3!");
        }
        newSet.setTraining(this);
        sets.add(newSet);
    }

    public Integer getTotalReps() {
        return sets.stream()
                   .mapToInt(TrainingSet::getReps)
                   .sum();
    }

    public List<TrainingSet> getSets() {
        return List.copyOf(sets);
    }
}
