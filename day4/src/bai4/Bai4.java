package bai4;

public class Bai4 {

    public static double convertInchesToCentimeter(double value) {
        UnitConversions inchesToCentimeters = value1 -> value1*2.54;
        return inchesToCentimeters.conversion(value);
    }

    public static double convertGallonsToLiters(double value) {
        UnitConversions gallonsToLiters = value1 -> value1*4.5461;
        return gallonsToLiters.conversion(value);
    }

    public static double convertMilesToKilometers(double value) {
        UnitConversions milesToKilometers  = value1 -> value1*1.609314;
        return milesToKilometers .conversion(value);
    }

    public static void main(String[] args) {
        System.out.println(convertGallonsToLiters(1));
        System.out.println(convertInchesToCentimeter(1));
        System.out.println(convertMilesToKilometers(1));
    }
}
