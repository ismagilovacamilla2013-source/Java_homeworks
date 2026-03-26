package com.example.lesson_7;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ArithmeticOperationsTest {
    private ArithmeticOperations arithmetic;

    @BeforeEach
    void setUp() {
        arithmetic = new ArithmeticOperations();
    }

    @Test
    @DisplayName("Тест сложения: 2 + 3 = 5")
    void testAddPositiveNumbers() {
        int result = arithmetic.add(2, 3);
        Assertions.assertEquals(5, result);
    }

    @Test
    @DisplayName("Тест сложения: -2 + (-3) = -5")
    void testAddNegativeNumbers() {
        int result = arithmetic.add(-2, -3);
        Assertions.assertEquals(-5, result);
    }

    @Test
    @DisplayName("Тест сложения: -2 + 2 = 0")
    void testAddPositiveAndNegative() {
        int result = arithmetic.add(-2, 2);
        Assertions.assertEquals(0, result);
    }

    @Test
    @DisplayName("Тест вычитания: 5 - 3 = 2")
    void testSubtractPositiveNumbers() {
        int result = arithmetic.subtract(5, 3);
        Assertions.assertEquals(2, result);
    }

    @Test
    @DisplayName("Тест вычитания: 2 - 6 = -4")
    void testSubtractNegativeResult() {
        int result = arithmetic.subtract(2, 6);
        Assertions.assertEquals(-4, result);
    }

    @Test
    @DisplayName("Тест вычитания: 10 - 10 = 0")
    void testSubtractEqualNumbers() {
        int result = arithmetic.subtract(10, 10);
        Assertions.assertEquals(0, result);
    }

    @Test
    @DisplayName("Тест умножения: 3 * 5 = 15")
    void testMultiplyPositiveNumbers() {
        int result = arithmetic.multiply(3, 5);
        Assertions.assertEquals(15, result);
    }

    @Test
    @DisplayName("Тест умножения: 5 * 0 = 0")
    void testMultiplyWithZero() {
        int result = arithmetic.multiply(5, 0);
        Assertions.assertEquals(0, result);
    }

    @Test
    @DisplayName("Тест умножения: -2 * 3 = -6")
    void testMultiplyNegativeNumbers() {
        int result = arithmetic.multiply(-2, 3);
        Assertions.assertEquals(-6, result);
    }

    @Test
    @DisplayName("Тест деления: 6 / 3 = 2")
    void testDividePositiveNumbers() {
        double result = arithmetic.divide(6, 3);
        Assertions.assertEquals(2.0, result);
    }

    @Test
    @DisplayName("Тест деления: 5 / 2 = 2.5")
    void testDivideWithRemainder() {
        double result = arithmetic.divide(5, 2);
        Assertions.assertEquals(2.5, result);
    }

    @Test
    @DisplayName("Тест деления на ноль: ожидается исключение")
    void testDivideByZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            arithmetic.divide(5, 0);
        });
    }
}