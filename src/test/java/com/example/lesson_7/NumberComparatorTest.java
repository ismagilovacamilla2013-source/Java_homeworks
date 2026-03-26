package com.example.lesson_7;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

public class NumberComparatorTest {

    private NumberComparator comparator;

    @BeforeMethod
    public void setUp() {
        comparator = new NumberComparator();
    }

    @Test
    public void testCompareFirstGreater() {
        int result = comparator.compare(5, 3);
        Assert.assertTrue(result > 0);
    }

    @Test
    public void testCompareFirstLess() {
        int result = comparator.compare(2, 5);
        Assert.assertTrue(result < 0);
    }

    @Test
    public void testCompareEqual() {
        int result = comparator.compare(4, 4);
        Assert.assertEquals(result, 0);
    }

    @Test
    public void testCompareWithMessageGreater() {
        String message = comparator.compareWithMessage(5, 3);
        Assert.assertEquals(message, "5 больше чем 3");
    }

    @Test
    public void testCompareWithMessageLess() {
        String message = comparator.compareWithMessage(2, 5);
        Assert.assertEquals(message, "2 меньше чем 5");
    }

    @Test
    public void testCompareWithMessageEqual() {
        String message = comparator.compareWithMessage(4, 4);
        Assert.assertEquals(message, "4 равно 4");
    }

    @Test
    public void testIsGreaterTrue() {
        Assert.assertTrue(comparator.isGreater(5, 3));
    }

    @Test
    public void testIsGreaterFalse() {
        Assert.assertFalse(comparator.isGreater(2, 5));
    }

    @Test
    public void testIsLessTrue() {
        Assert.assertTrue(comparator.isLess(2, 5));
    }

    @Test
    public void testIsLessFalse() {
        Assert.assertFalse(comparator.isLess(5, 3));
    }

    @Test
    public void testIsEqualTrue() {
        Assert.assertTrue(comparator.isEqual(4, 4));
    }

    @Test
    public void testIsEqualFalse() {
        Assert.assertFalse(comparator.isEqual(5, 3));
    }
}