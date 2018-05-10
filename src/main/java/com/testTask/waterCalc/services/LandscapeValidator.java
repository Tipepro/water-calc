package com.testTask.waterCalc.services;

import java.util.Arrays;

class LandscapeValidator {
    private final int MAX_LANDSCAPE_SIZE = 32000;
    private final int MAX_LANDSCAPE_HEIGHT = 32000;

    void validate(int[] landscape) {
        if (landscape == null) {
            throw new IllegalArgumentException("Landscape is null");
        }
        if (landscape.length > MAX_LANDSCAPE_SIZE) {
            throw new IllegalArgumentException("Landscape size is too big: " +
                    landscape.length + " > " + MAX_LANDSCAPE_SIZE);
        }
        Arrays.stream(landscape)
                .filter(i -> i > MAX_LANDSCAPE_HEIGHT || i < 0)
                .findAny()
                .ifPresent(i -> {
                    throw new IllegalArgumentException("There is a hill of incorrect height " + i);
                });
    }
}
