package com.testTask.waterCalc.services;

public class WaterCalculator {
    private final LandscapeValidator landscapeValidator = new LandscapeValidator();

    public int calc(int[] landscape) {
        landscapeValidator.validate(landscape);
        return calcWaterAmount(landscape);
    }

    private int calcWaterAmount(int[] landscape) {
        int result = 0;

        int leftMax = 0;
        int rightMax = 0;

        int leftIndex = 0;
        int rightIndex = landscape.length - 1;

        while (leftIndex <= rightIndex) {
            if (landscape[leftIndex] < landscape[rightIndex]) {
                if (landscape[leftIndex] > leftMax) {
                    leftMax = landscape[leftIndex];
                } else {
                    result += leftMax - landscape[leftIndex];
                }
                leftIndex++;
            } else {
                if (landscape[rightIndex] > rightMax) {
                    rightMax = landscape[rightIndex];
                } else {
                    result += rightMax - landscape[rightIndex];
                }
                rightIndex--;
            }
        }
        return result;
    }
}
