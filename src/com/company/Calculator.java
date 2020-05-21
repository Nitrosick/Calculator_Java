package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        solution();
        }

    public static void solution() {
        String task = "";
        double result = 0;
        boolean minus = false;
        System.out.println("Введите выражение");
        try {
            String startTask = scan.nextLine().replace(" ", ""); // Ввод выражения

            //Проверка на первое отрицательное число
            if (startTask.charAt(0) == '-') {
                minus = true;
                task = startTask.substring(1);
            } else {
                task = startTask;
            }

            String[] digits = task.split("[\\+\\-]"); // Числа
            char[] task1 = task.toCharArray(); // Массив символов выражения

            // Арифметические знаки
            ArrayList<Character> symbols = new ArrayList<>();
            for (int i = 0; i < task1.length ; i++) {
                if (task1[i] == '-' || task1[i] == '+') {
                    symbols.add(task1[i]);
                }
            }

            // Вычисление
            if (minus) {
                result = Double.parseDouble(digits[0]) * -1;
            } else {
                result = Double.parseDouble(digits[0]);
            }
            for (int i = 0; i < symbols.size(); i++) {
                if (symbols.get(i) == '+') {
                    result = result + Double.parseDouble(digits[i+1]);
                } else {
                    result = result - Double.parseDouble(digits[i+1]);
                }
            }

            System.out.println("Результат: " + result);
            solution();
        }
        catch (Exception e) {
            System.out.println("Ошибка ввода");
            solution();
        }
    }
}