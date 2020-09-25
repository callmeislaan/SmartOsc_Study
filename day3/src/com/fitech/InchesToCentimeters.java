package com.fitech;

public class InchesToCentimeters extends UnitConversion {

    @Override
    public double conversion(double value) {
        return value*2.54;
    }
}
