package com.miltrainApp.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="training_sets")
@Getter
@Setter
public class TrainingSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer reps;

    @JsonBackReference
    @ManyToOne
    private Training training;
}
