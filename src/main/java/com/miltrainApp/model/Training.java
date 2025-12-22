package com.miltrainApp.model;


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

    @Enumerated(EnumType.STRING)
    private ExerciseType exerciseType;

    @OneToMany(mappedBy = "training", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TrainingSet> sets = new ArrayList<>(3);

    public Training(Long userId, ExerciseType exerciseType) {
        this.userId = userId;
        this.exerciseType = exerciseType;
    }


    public void addSet(TrainingSet set) {
        if (sets.size() >= 3) {
            throw new TrainingMaxSetLimitException("Max sets is 3!");
        }
        set.setTraining(this);
        sets.add(set);
    }

    public Integer getTotalReps() {
        return sets.stream()
                   .mapToInt(TrainingSet::getReps)
                   .sum();
    }
}
