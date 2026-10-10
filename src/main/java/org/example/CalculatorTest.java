package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private static final Calculator calculator = new Calculator();

    @Test
    public void testCalculate() {
        float result = calculator.calculate("10 cm + 1 m - 10 mm","mm");

        assertEquals(1090f, result);
    }


    @Test
    public void testIfTheOperatorIsForAddition() {
        float result = calculator.calculate("10 m + 2 cm", "m");

        assertEquals(10.02f, result);

    }

    @Test
    public void testIfTheOperatorIsForSubtraction() {
        float result = calculator.calculate("5 dm - 2 cm", "m");
        assertEquals(0.48f, result);
    }

    @Test
    public void testIfTheOperatorIsForMultiplication() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.calculate("5 dm * 2 cm", "m"));
    }

    @Test
    public void testIfTheOperatorIsForDivision() {
        assertThrows(IllegalArgumentException.class, () -> Calculator.calculate("5 dm / 2 cm", "m"));
    }

    @Test
    public void testIfTheStringIsNotDigit() {
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(" dm", "m"));
    }


}

