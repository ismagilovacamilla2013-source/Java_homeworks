package com.example.lesson_7;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class FactorialCalculatorTest {

    private FactorialCalculator factorialCalculator;

    @BeforeMethod
    public void setUp() {
        factorialCalculator = new FactorialCalculator();
        System.out.println("Создан экземпляр FactorialCalculator для теста");
    }

    @Test
    public void testFactorialZero() {
        Assert.assertEquals(factorialCalculator.factorial(0), 1);
        System.out.println("Тест факториала 0 пройден");
    }

    @Test
    public void testFactorialOne() {
        Assert.assertEquals(factorialCalculator.factorial(1), 1);
        System.out.println("Тест факториала 1 пройден");
    }

    @Test
    public void testFactorialTwo() {
        Assert.assertEquals(factorialCalculator.factorial(2), 2);
        System.out.println("Тест факториала 2 пройден");
    }

    @Test
    public void testFactorialThree() {
        Assert.assertEquals(factorialCalculator.factorial(3), 6);
        System.out.println("Тест факториала 3 пройден");
    }

    @Test
    public void testFactorialFour() {
        Assert.assertEquals(factorialCalculator.factorial(4), 24);
        System.out.println("Тест факториала 4 пройден");
    }

    @Test
    public void testFactorialFive() {
        Assert.assertEquals(factorialCalculator.factorial(5), 120);
        System.out.println("Тест факториала 5 пройден");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        factorialCalculator.factorial(-1);
        System.out.println("Тест на отрицательное число пройден");
    }
}
