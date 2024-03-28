package com.gmail.zavsek_o2;

import java.util.Arrays;

public class ArrayValueCalculator {

    public static int doCalc(String[][] array) throws ArraySizeException, ArrayDataException {
        if (array.length != 4 || Arrays.stream(array).anyMatch(row -> row.length != 4)) {
            throw new ArraySizeException("Масив повинен бути розміром 4x4");
        }

        int sum = 0;
        for (String[] strings : array) {
            for (String string : strings) {
                try {
                    sum += Integer.parseInt(string);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException(e);
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = doCalc(array);
            System.out.println("Результат обчислення: " + result);
        } catch (ArraySizeException e) {
            System.out.println("Помилка: " + e.getMessage());
        } catch (ArrayDataException e) {
            System.out.println("Помилка: " + e.getMessage());
            System.out.println("Деталі: " + e.getCause().getMessage());
        }
    }
}
