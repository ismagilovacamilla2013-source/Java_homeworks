package com.example.lesson_7;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class NumberComparatorTest {
    private NumberComparator comparator;

    @BeforeEach
    void setUp() {
        comparator = new NumberComparator();
    }

    @Test
    @DisplayName("Тест compare: 5 > 3, результат должен быть положительным")
    void testCompareFirstGreater() {
        int result = comparator.compare(5, 3);
        Assertions.assertTrue(result > 0);
    }

    @Test
    @DisplayName("Тест compare: 2 < 5, результат должен быть отрицательным")
    void testCompareFirstLess() {
        int result = comparator.compare(2, 5);
        Assertions.assertTrue(result < 0);
    }

    @Test
    @DisplayName("Тест compare: 4 == 4, результат должен быть 0")
    void testCompareEqual() {
        int result = comparator.compare(4, 4);
        Assertions.assertEquals(0, result);
    }

    @Test
    @DisplayName("Тест compareWithMessage: 5 больше чем 3")
    void testCompareWithMessageGreater() {
        String message = comparator.compareWithMessage(5, 3);
        Assertions.assertEquals("5 больше чем 3", message);
    }

    @Test
    @DisplayName("Тест compareWithMessage: 2 меньше чем 5")
    void testCompareWithMessageLess() {
        String message = comparator.compareWithMessage(2, 5);
        Assertions.assertEquals("2 меньше чем 5", message);
    }

    @Test
    @DisplayName("Тест compareWithMessage: 4 равно 4")
    void testCompareWithMessageEqual() {
        String message = comparator.compareWithMessage(4, 4);
        Assertions.assertEquals("4 равно 4", message);
    }

    @Test
    @DisplayName("Тест isGreater: 5 > 3 должно вернуть true")
    void testIsGreaterTrue() {
        boolean result = comparator.isGreater(5, 3);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Тест isGreater: 2 > 5 должно вернуть false")
    void testIsGreaterFalse() {
        boolean result = comparator.isGreater(2, 5);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Тест isLess: 2 < 5 должно вернуть true")
    void testIsLessTrue() {
        boolean result = comparator.isLess(2, 5);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Тест isLess: 5 < 3 должно вернуть false")
    void testIsLessFalse() {
        boolean result = comparator.isLess(5, 3);
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Тест isEqual: 4 == 4 должно вернуть true")
    void testIsEqualTrue() {
        boolean result = comparator.isEqual(4, 4);
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Тест isEqual: 5 == 3 должно вернуть false")
    void testIsEqualFalse() {
        boolean result = comparator.isEqual(5, 3);
        Assertions.assertFalse(result);
    }
}
