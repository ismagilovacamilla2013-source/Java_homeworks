package com.example.lesson_5;

public class ArrayProcessor {

    public static int processArray(String[][] array)
            throws MyArraySizeException, MyArrayDataException {
        if (array == null) {
            throw new MyArraySizeException("Массив не может быть null");
        }
        if (array.length != 4) {
            throw new MyArraySizeException("Массив должен быть размером 4x4. " +
                    "Количество строк: " + array.length);
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                throw new MyArraySizeException("Строка " + i + " равна null");
            }
            if (array[i].length != 4) {
                throw new MyArraySizeException("Строка " + i + " имеет размер " +
                        array[i].length + ". Должна быть 4");
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    int value = Integer.parseInt(array[i][j]);
                    sum += value;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            "Ошибка преобразования в ячейке [" + i + "][" + j +
                                    "]: '" + array[i][j] + "' не является числом", i, j);
                }
            }
        }
        return sum;
    }

    public static void demonstrateArrayIndexOutOfBounds() {
        int[] numbers = {10, 20, 30, 40, 50};
        try {
            int value = numbers[10];
            System.out.println("Значение: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка индекса массива: " + e);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        try {
            int result = processArray(correctArray);
            System.out.println("Сумма элементов: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e);
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка в данных: " + e);
            System.out.println("Проблемная ячейка: [" + e.getRow() + "][" + e.getCol() + "]");
        }

        String[][] wrongSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };
        try {
            int result = processArray(wrongSizeArray);
            System.out.println("Сумма: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e);
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка в данных: " + e);
            System.out.println("Проблемная ячейка: [" + e.getRow() + "][" + e.getCol() + "]");
        }

        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "abc", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        try {
            int result = processArray(invalidDataArray);
            System.out.println("Сумма: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e);
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка в данных: " + e);
            System.out.println("Проблемная ячейка: [" + e.getRow() + "][" + e.getCol() + "]");
        }

        System.out.println();
        demonstrateArrayIndexOutOfBounds();
    }

}
