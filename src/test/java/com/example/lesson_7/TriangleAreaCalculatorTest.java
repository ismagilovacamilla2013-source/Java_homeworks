package com.example.lesson_7;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class TriangleAreaCalculatorTest {

    private TriangleAreaCalculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new TriangleAreaCalculator();
    }

    @Test
    public void testAreaBase5Height4() {
        double area = calculator.calculateArea(5, 4);
        Assert.assertEquals(area, 10.0);
    }

    @Test
    public void testAreaBase3Height5() {
        double area = calculator.calculateArea(3, 5);
        Assert.assertEquals(area, 7.5);
    }

    @Test
    public void testAreaBase10Height8() {
        double area = calculator.calculateArea(10, 8);
        Assert.assertEquals(area, 40.0);
    }

    @Test
    public void testAreaBase2_5Height4() {
        double area = calculator.calculateArea(2.5, 4);
        Assert.assertEquals(area, 5.0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testWithZeroBase() {
        calculator.calculateArea(0, 5);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testWithZeroHeight() {
        calculator.calculateArea(5, 0);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testWithNegativeBase() {
        calculator.calculateArea(-5, 4);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testWithNegativeHeight() {
        calculator.calculateArea(5, -4);
    }
}