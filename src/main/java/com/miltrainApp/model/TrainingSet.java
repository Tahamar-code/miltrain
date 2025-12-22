package com.miltrainApp.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "training_sets")
@Getter
@Setter
public class TrainingSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private Integer reps;

    @ManyToOne
    @JoinColumn(name = "training_id")
    @JsonIgnore
    private Training training;
}
