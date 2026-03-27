package com.example.lesson_7;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TriangleAreaCalculatorTest {
    private TriangleAreaCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new TriangleAreaCalculator();
    }

    @Test
    @DisplayName("Тест площади треугольника: основание 5, высота 4")
    void testAreaBase5Height4() {
        double area = calculator.calculateArea(5, 4);
        Assertions.assertEquals(10.0, area);
    }

    @Test
    @DisplayName("Тест площади треугольника: основание 3, высота 5")
    void testAreaBase3Height5() {
        double area = calculator.calculateArea(3, 5);
        Assertions.assertEquals(7.5, area);
    }

    @Test
    @DisplayName("Тест площади треугольника: основание 10, высота 8")
    void testAreaBase10Height8() {
        double area = calculator.calculateArea(10, 8);
        Assertions.assertEquals(40.0, area);
    }

    @Test
    @DisplayName("Тест площади треугольника: основание 2.5, высота 4")
    void testAreaBase2_5Height4() {
        double area = calculator.calculateArea(2.5, 4);
        Assertions.assertEquals(5.0, area);
    }

    @Test
    @DisplayName("Тест с нулевым основанием: ожидается исключение")
    void testWithZeroBase() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateArea(0, 5);
        });
    }

    @Test
    @DisplayName("Тест с нулевой высотой: ожидается исключение")
    void testWithZeroHeight() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateArea(5, 0);
        });
    }

    @Test
    @DisplayName("Тест с отрицательным основанием: ожидается исключение")
    void testWithNegativeBase() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateArea(-5, 4);
        });
    }

    @Test
    @DisplayName("Тест с отрицательной высотой: ожидается исключение")
    void testWithNegativeHeight() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateArea(5, -4);
        });
    }
}
