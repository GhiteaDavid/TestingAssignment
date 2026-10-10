package org.example;

import java.util.*;

public class Calculator {

    public static float calculate(String expression, String resultUnit) {
        float result = 0;

        float number = 0;

        String unit = "";

        String operator = "+";

        Queue<String> parts = new LinkedList<>(Arrays.asList(expression.split(" ")));

        UnitConverter converter = new UnitConverter();

        while (!parts.isEmpty()) {

            String part = parts.poll();

            if (part.equals("")) {
                continue;
            }

            if (Character.isDigit(part.charAt(0))) {
                number = Float.parseFloat(part);

                unit = parts.poll();

                number = converter.ConvertToMeter(number, unit);


                if (operator.equals("+")) {
                    result += number;
                } else if (operator.equals("-")) {
                    result -= number;
                } else if (operator.equals("*")) {
                    throw new IllegalArgumentException("Operator Invalid");
                } else if (operator.equals("/")) {
                    throw new IllegalArgumentException("Operator Invalid");
                }

                operator = parts.poll();

            } else {
                throw new IllegalArgumentException("Invalid expression");
            }
        }
        return converter.fromMeter(result, resultUnit);
    }
}
