package com.example.lesson_4;

public class FigureMain {
    public static void main(String[] args){
        Circle c1 = new Circle(5,"Красный", "Синий");
        Rectangle r1 = new Rectangle(4, 6, "Зеленый", "Синий");
        Triangle t1 = new Triangle(3, 4, 5, "Оранжевый", "Красный");
        System.out.println("КРУГ:");
        System.out.println("  Радиус: " + c1.radius);
        System.out.println("  Площадь: " + c1.getArea());
        System.out.println("  Периметр: " + c1.getPerimeter());
        System.out.println("  Цвет фона: " + c1.getFillColor());
        System.out.println("  Цвет границ: " + c1.getBorderColor());
        System.out.println("ПРЯМОУГОЛЬНИК:");
        System.out.println("  Ширина: " + r1.width + ", Высота: " + r1.height);
        System.out.println("  Площадь: " + r1.getArea());
        System.out.println("  Периметр: " + r1.getPerimeter());
        System.out.println("  Цвет фона: " + r1.getFillColor());
        System.out.println("  Цвет границ: " + r1.getBorderColor());
        System.out.println("ТРЕУГОЛЬНИК:");
        System.out.println("  Стороны: " + t1.sideA + ", " + t1.sideB + ", " + t1.sideC);
        System.out.println("  Площадь: " + t1.getArea());
        System.out.println("  Периметр: " + t1.getPerimeter());
        System.out.println("  Цвет фона: " + t1.getFillColor());
        System.out.println("  Цвет границ: " + t1.getBorderColor());
    }
}
