package org.example;

public class UnitConverter {

    public float ConvertToMeter(float number, String unit) {
        if (unit.equals("mm")) {
            number = number / 1000;
        } else if (unit.equals("cm")) {
            number = number / 100;
        } else if (unit.equals("dm")) {
            number = number / 10;
        } else if (unit.equals("m")) {
            number = number / 1;
        } else if (unit.equals("km")) {
            number = number * 1000;
        }

        return number;
    }

    public float fromMeter(float number, String unit) {
        if (unit.equals("mm")) {
            number = number * 1000;
        } else if (unit.equals("cm")) {
            number = number * 100;
        } else if (unit.equals("dm")) {
            number = number * 10;
        } else if (unit.equals("m")) {
            number = number * 1;
        } else if (unit.equals("km")) {
            number = number / 1000;
        }
        return number;
    }
}