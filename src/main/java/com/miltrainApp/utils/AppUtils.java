package com.miltrainApp.utils;

import java.util.UUID;

public class AppUtils {

    private AppUtils() {
    }

    public static UUID generateUserId() {
        return UUID.randomUUID();
    }

}
