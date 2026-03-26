package com.example.lesson_7;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FactorialCalculatorTest {
    private FactorialCalculator factorialCalculator;

    @BeforeEach
    void setUp() {
        factorialCalculator = new FactorialCalculator();
    }

    @Test
    @DisplayName("Тест факториала 0: 0! = 1")
    void testFactorialZero() {
        Assertions.assertEquals(1, factorialCalculator.factorial(0));
    }

    @Test
    @DisplayName("Тест факториала 1: 1! = 1")
    void testFactorialOne() {
        Assertions.assertEquals(1, factorialCalculator.factorial(1));
    }

    @Test
    @DisplayName("Тест факториала 2: 2! = 2")
    void testFactorialTwo() {
        Assertions.assertEquals(2, factorialCalculator.factorial(2));
    }

    @Test
    @DisplayName("Тест факториала 3: 3! = 6")
    void testFactorialThree() {
        Assertions.assertEquals(6, factorialCalculator.factorial(3));
    }

    @Test
    @DisplayName("Тест факториала 4: 4! = 24")
    void testFactorialFour() {
        Assertions.assertEquals(24, factorialCalculator.factorial(4));
    }

    @Test
    @DisplayName("Тест факториала 5: 5! = 120")
    void testFactorialFive() {
        Assertions.assertEquals(120, factorialCalculator.factorial(5));
    }

    @Test
    @DisplayName("Тест факториала отрицательного числа: ожидается исключение")
    void testFactorialNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            factorialCalculator.factorial(-1);
        });
    }
}
