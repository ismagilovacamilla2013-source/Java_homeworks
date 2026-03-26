package com.example.lesson_7;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class ArithmeticOperationsTest {

    private ArithmeticOperations arithmetic;

    @BeforeMethod
    public void setUp() {
        arithmetic = new ArithmeticOperations();
    }

    @Test
    public void testAddPositiveNumbers() {
        Assert.assertEquals(arithmetic.add(2, 3), 5);
    }

    @Test
    public void testAddNegativeNumbers() {
        Assert.assertEquals(arithmetic.add(-2, -3), -5);
    }

    @Test
    public void testAddPositiveAndNegative() {
        Assert.assertEquals(arithmetic.add(-2, 2), 0);
    }

    @Test
    public void testSubtractPositiveNumbers() {
        Assert.assertEquals(arithmetic.subtract(5, 3), 2);
    }

    @Test
    public void testSubtractNegativeResult() {
        Assert.assertEquals(arithmetic.subtract(2, 6), -4);
    }

    @Test
    public void testSubtractEqualNumbers() {
        Assert.assertEquals(arithmetic.subtract(10, 10), 0);
    }

    @Test
    public void testMultiplyPositiveNumbers() {
        Assert.assertEquals(arithmetic.multiply(3, 5), 15);
    }

    @Test
    public void testMultiplyWithZero() {
        Assert.assertEquals(arithmetic.multiply(5, 0), 0);
    }

    @Test
    public void testMultiplyNegativeNumbers() {
        Assert.assertEquals(arithmetic.multiply(-2, 3), -6);
    }

    @Test
    public void testDividePositiveNumbers() {
        Assert.assertEquals(arithmetic.divide(6, 3), 2.0);
    }

    @Test
    public void testDivideWithRemainder() {
        Assert.assertEquals(arithmetic.divide(5, 2), 2.5);
    }

    @Test(expectedExceptions = ArithmeticException.class)
    public void testDivideByZero() {
        arithmetic.divide(5, 0);
    }
}