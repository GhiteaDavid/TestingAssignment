package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ConverterTest {
    @ParameterizedTest
    @MethodSource("convertToMeterTestUnitProvider")
    public void convertToMeterTest(float value, String unit, float expected) {
        Calculator calculator = new Calculator();
        UnitConverter converter = new UnitConverter();
        float result = converter.ConvertToMeter(value, unit);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> convertToMeterTestUnitProvider() {
        return Stream.of(
                Arguments.of(10, "mm", 0.01f),
                Arguments.of(10, "cm", 0.1f),
                Arguments.of(10, "dm", 1f),
                Arguments.of(10, "m", 10f),
                Arguments.of(10, "km", 10000f)
        );
    }

    @ParameterizedTest
    @MethodSource("converterFromMeterTestUnitProvider")
    public void convertFromMeterTest(float value, String unit, float expected) {
        Calculator calculator = new Calculator();
        UnitConverter converter = new UnitConverter();
        float result = converter.fromMeter(value, unit);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> converterFromMeterTestUnitProvider() {
        return Stream.of(
                Arguments.of(10, "mm", 10000f),
                Arguments.of(10, "cm", 1000f),
                Arguments.of(10, "dm", 100f),
                Arguments.of(10, "m", 10f),
                Arguments.of(10, "km", 0.01f)
        );
    }

}