package com.albert.argentum;

import java.util.Scanner;
import com.albert.argentum.service.ExpenseTracker;

public class Main {

    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();  // Your main logic class
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        clearScreen();
        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add a transaction");
            System.out.println("2. View all transactions");
            System.out.println("4. Save to database");
            System.out.println("5. Exit");

            System.out.print("> ");
            if (!scanner.hasNext()){
                break;
            }
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    tracker.addTransaction(scanner);  // May pass scanner for input
                    break;
                case "2":
                    tracker.viewTransactions();
                    break;
                case "4":
                    tracker.exportCSV();
                    break;
                case "5":
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                default:
                    wrongInput();
            }
            clearScreen();
        }

        scanner.close();
    }

}

