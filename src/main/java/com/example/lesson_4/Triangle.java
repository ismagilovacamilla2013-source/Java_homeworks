package com.example.lesson_4;

public class Triangle implements Figure {
    double sideA;
    double sideB;
    double sideC;
    String fillColor;
    String borderColor;
    public Triangle(double a, double b, double c, String fill, String border){
        if (a + b <= c) {
            System.out.println("Ошибка!");
            return;
        }
        if (a + c <= b) {
            System.out.println("Ошибка!");
            return;
        }
        if (b + c <= a) {
            System.out.println("Ошибка!");
            return;
        }
        sideA = a;
        sideB = b;
        sideC = c;
        fillColor = fill;
        borderColor = border;
    }
    public double getPerimeter(){
        return sideA + sideB + sideC;
    }
    public double getArea(){
        double p = getPerimeter() / 2;
        double area = p * (p - sideA) * (p - sideB) * (p - sideC);
        return Math.sqrt(area);
    }
    public String getFillColor() {
        return fillColor;
    }

    public String getBorderColor() {
        return borderColor;
    }
}
