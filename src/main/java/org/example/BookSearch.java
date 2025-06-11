package org.example;

import java.io.*;
import java.util.Scanner;

public class BookSearch {
    public static void main(String[] args) {
        try {
            File file = new File("src/main/resources/books.txt");
            Scanner scanner = new Scanner(file);
            Scanner input = new Scanner(System.in);

            System.out.print("Введіть назву книги: ");
            String searchTitle = input.nextLine().trim().toLowerCase();

            boolean found = false;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(";", 3); // автор;назва;рік

                if (parts.length == 3) {
                    String author = parts[0].trim();
                    String title = parts[1].trim().toLowerCase();
                    String year = parts[2].trim();

                    if (title.equals(searchTitle)) {
                        System.out.println("Знайдено книгу:");
                        System.out.println("Автор: " + author);
                        System.out.println("Рік видання: " + year);
                        found = true;
                    }
                }
            }

            if (found == false) {
                System.out.println("Книгу з такою назвою не знайдено");
            }

            scanner.close();
            input.close();

        } catch (IOException e) {
            System.out.println("помилка: " + e.getMessage());
        }
    }
}
