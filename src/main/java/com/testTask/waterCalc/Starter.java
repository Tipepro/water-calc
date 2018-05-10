package com.testTask.waterCalc;

import com.testTask.waterCalc.services.WaterCalculator;

import java.util.Scanner;

public class Starter {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in, "UTF-8")) {
            System.out.println("Please enter the number of positions in landscape: ");
            int size = scanner.nextInt();
            int[] landscape = new int[size];
            for (int i = 0; i < size; i++) {
                System.out.println("Please enter " + i + " element");
                landscape[i] = scanner.nextInt();
            }

            WaterCalculator waterCalculator = new WaterCalculator();
            System.out.println("Water amount is " + waterCalculator.calc(landscape));
        }
    }
}
