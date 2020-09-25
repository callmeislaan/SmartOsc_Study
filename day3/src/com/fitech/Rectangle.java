package com.fitech;

public class Rectangle extends Shape {

    int height = 8;
    int width = 10;

    public Rectangle() {
    }

    @Override
    public Point centerPoint(Point point) {
        return new Point((point.getX() + width)/2, (point.getY() + height)/2);
    }
}
