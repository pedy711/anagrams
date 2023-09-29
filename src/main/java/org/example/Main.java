package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Anagram anagram = Anagram.getInstance();
    private static final int MENU_CHECK_ANAGRAMS = 1;
    private static final int MENU_SHOW_ANAGRAMS = 2;
    private static final int MENU_EXIT = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = getUserChoice(scanner);

            switch (choice) {
                case MENU_CHECK_ANAGRAMS:
                    checkAnagrams(scanner);
                    break;
                case MENU_SHOW_ANAGRAMS:
                    showAllAnagrams(scanner);
                    break;
                case MENU_EXIT:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Which feature would you like to choose?");
        System.out.println(MENU_CHECK_ANAGRAMS + ". Check if two texts are anagrams");
        System.out.println(MENU_SHOW_ANAGRAMS + ". Find all anagrams of a given text");
        System.out.println(MENU_EXIT + ". Exit");
    }

    private static int getUserChoice(Scanner scanner) {
        int choice = 0;
        try {
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
        } catch (java.util.InputMismatchException e) {
            scanner.nextLine(); // Consume the invalid input
        }
        return choice;
    }

    private static void checkAnagrams(Scanner scanner) {
        System.out.println("Enter the first text:");
        String text1 = scanner.nextLine();

        System.out.println("Enter the second text:");
        String text2 = scanner.nextLine();

        boolean isAnagram = anagram.areTextsAnagrams(text1, text2);

        if (isAnagram) {
            System.out.println("The two texts are anagrams");
        } else {
            System.out.println("The two texts are not anagrams");
        }
    }

    private static void showAllAnagrams(Scanner scanner) {
        System.out.println("Enter the string to find anagrams for:");
        String text = scanner.nextLine();

        List<String> anagrams = anagram.getAllAnagrams(text);

        if (anagrams.isEmpty()) {
            System.out.println("1");
        } else {
            System.out.println("The following are anagrams of the given string:");
            for (String anagram : anagrams) {
                System.out.println(anagram);
            }
        }
    }
}
