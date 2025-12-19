package com.miltrainApp;

import com.miltrainApp.exersize.ExerciseType;
import com.miltrainApp.exersize.Training;
import com.miltrainApp.userService.User;

public class Main {

    public static void main(String[] args) {
        User user = new User(1L, "Sergio", 34);
        Training training1 = new Training(1L, 1L, ExerciseType.PUSH_UPS);
        training1.addSet(30);
        training1.addSet(30);
        training1.addSet(30);
        System.out.println(training1.getTotalReps());
    }
}
