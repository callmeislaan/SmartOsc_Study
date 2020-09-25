package com.fitech;

public class MilesToKilometers extends UnitConversion{

    @Override
    public double conversion(double value) {
        return value*1.609314;
    }
}
