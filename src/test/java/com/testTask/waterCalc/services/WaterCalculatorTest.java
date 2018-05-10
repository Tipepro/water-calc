package com.testTask.waterCalc.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WaterCalculatorTest {
    private static final int MAX_HEIGHT = 32000;
    private final WaterCalculator waterCalculator = new WaterCalculator();

    @DisplayName("Test water calculation")
    @ParameterizedTest(name =
            "Expected result: {0} for given landscape: {1}")
    @CsvFileSource(resources = "/water-calc-test-data.csv")
    void testWaterCalc(int expectedResult, String landscapeCsv) {
        int[] landscape = getLandscapeFromCsv(landscapeCsv);

        assertEquals(expectedResult, waterCalculator.calc(landscape));
    }

    @Test
    @DisplayName("Test null landscape")
    void testNullLandscape() {
        assertThrows(IllegalArgumentException.class, () -> waterCalculator.calc(null));
    }

    @DisplayName("Test landscape height > 32000")
    @ParameterizedTest(name =
            "Landscape: {0}")
    @CsvSource({
            "'32001,0,0'",
            "'100000,100000,100000'",
            "'1,2,3,4,5,1000000'",
            "'0,0,-1'",
            "'32000,-32000,32000'",
            "'1000000,-1000000,1000000'",
    })
    void testIncorrectLandscapeHeight(String landscapeCsv) {
        int[] landscape = getLandscapeFromCsv(landscapeCsv);

        assertThrows(IllegalArgumentException.class, () -> waterCalculator.calc(landscape));
    }

    @DisplayName("Test landscape size > 32000")
    @ParameterizedTest(name =
            "Landscape size: {0}")
    @CsvSource({
            "32001", "100000", "1000000"
    })
    void testTooLongLandscape(int size) {
        int[] landscape = getRandomLandscapeOfSize(size);

        assertThrows(IllegalArgumentException.class, () -> waterCalculator.calc(landscape));
    }

    private int[] getLandscapeFromCsv(String landscapeCsv) {
        return Arrays.stream(landscapeCsv.split(","))
                .filter(s -> !s.isEmpty())
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private int[] getRandomLandscapeOfSize(int size) {
        return IntStream.rangeClosed(0, size - 1)
                .map(i -> ThreadLocalRandom.current().nextInt(MAX_HEIGHT + 1))
                .toArray();
    }
}