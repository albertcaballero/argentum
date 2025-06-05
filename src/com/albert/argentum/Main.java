package com.albert.argentum;

import java.util.Scanner;
import com.albert.argentum.ui.Screen;
import com.albert.argentum.service.ExpenseTracker;

public class Main {

    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();  // Your main logic class
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        String input = "";

        Screen.clearScreen();
        while (running) {
            Screen.printOpts();
            if (!scanner.hasNextLine()){
                break;
            }
            input = scanner.nextLine().trim();
            if (input.isEmpty()){
                continue;
            }

            switch (input) {
                case "1":
                    tracker.addTransaction(scanner);  // May pass scanner for input
                    break;
                case "2":
                    tracker.viewTransactions();
                    break;
                case "3":
                    System.out.println(tracker);
                    break;
                case "4":
                    tracker.exportCSV();
                    break;
                case "5":
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    Screen.wrongInput(scanner);
            }
            System.out.println("\nPress ENTER to continue");
            scanner.nextLine();
            Screen.clearScreen();
        }

        scanner.close();
    }

}

