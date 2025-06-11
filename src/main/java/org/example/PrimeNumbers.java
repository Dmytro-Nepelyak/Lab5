package org.example;

import java.io.*;
import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
        try {
            File inputFile = new File("src/main/resources/numbers.txt"); // вхідний файл
            File outputFile = new File("src/main/resources/prime_numbers.txt"); // вихідний файл
            Scanner scanner = new Scanner(inputFile);
            PrintWriter writer = new PrintWriter(outputFile);

            while (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                if (Prime(number)) {
                    writer.println(number);
                }
            }

            scanner.close();
            writer.close();
            System.out.println("Прості числа записані у prime_numbers.txt");

        } catch (IOException e) {
            System.out.println("помилка: " + e.getMessage());
        }
    }

    // перевіряємо чи є число простим
    public static boolean Prime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
