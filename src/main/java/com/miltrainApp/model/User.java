package com.miltrainApp.model;


import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.atomic.AtomicLong;

@Getter
public class User {
    private static final AtomicLong userIdCounter = new AtomicLong(0);

    private Long id;
    @Setter
    private String name;

    @Setter
    private Integer age;

    public User(String name, Integer age) {
        this.id = generateTrainingId();
        this.name = name;
        this.age = age;
    }

    public static long generateTrainingId() {
        return userIdCounter.incrementAndGet();
    }


}
