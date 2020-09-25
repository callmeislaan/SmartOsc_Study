package com.fitech;

public class LabeledPoint extends Point {
    private String label;

    public LabeledPoint() {
    }

    public LabeledPoint(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }

    @Override
    public String toString() {
        return "LabeledPoint{" +
                "label='" + label + '\'' + ", " + super.toString() +
                '}';
    }
}
