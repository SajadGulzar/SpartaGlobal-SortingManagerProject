package com.spartaglobal.sortManager.View;

import java.util.Scanner;

public class QuestionTwo {
    public int questionTwoMethod() {

        Scanner scanner = new Scanner(System.in);
        int sortChoice;

        System.out.println("\nNow enter your sort preference: \n" +
                "1) Bubble Sort \n" +
                "2) Binary Sort \n" +
                "3) Merge Sort\n");
        do {
            System.out.print("\nPlease choose a number from 1 to 3 as outlined: ");
            while (!scanner.hasNextInt()) {
                String input = scanner.next();
                System.out.printf("\n \"%s\" is not a valid choice. Please try again: ", input);
            }
            sortChoice = scanner.nextInt();
        } while (sortChoice < 1 || sortChoice > 3);
        return sortChoice;
    }
}
