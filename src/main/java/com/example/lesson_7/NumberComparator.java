package com.example.lesson_7;

public class NumberComparator {
    public int compare(int a, int b) {
        return Integer.compare(a, b);
    }

    public String compareWithMessage(int a, int b) {
        if (a > b) {
            return a + " больше чем " + b;
        } else if (a < b) {
            return a + " меньше чем " + b;
        } else {
            return a + " равно " + b;
        }
    }

    public boolean isGreater(int a, int b) {
        return a > b;
    }

    public boolean isLess(int a, int b) {
        return a < b;
    }

    public boolean isEqual(int a, int b) {
        return a == b;
    }
}
