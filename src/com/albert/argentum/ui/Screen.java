
package com.albert.argentum.ui;
import java.util.Scanner;

public final class Screen{

    private Screen(){
        throw new UnsupportedOperationException("Utility class");
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("=== Argentum ===");
    }
     
    public static void wrongInput(Scanner scanner){
        System.out.println("Invalid option.");
    }

    public static void printOpts(){
        System.out.println("\nChoose an option:");
        System.out.println("1. Add a transaction");
        System.out.println("2. View all transactions");
        System.out.println("3. Print all transactions");
        System.out.println("4. Save to database");
        System.out.println("5. Exit");
        System.out.print("> ");
    }

    public static String tabline(String str, int len){
        String ret = "";
        for (int i = 0; i < len; ++i){
            if (i >= str.length())
                ret += ' ';
            else
                ret += str.charAt(i);
        }
        return ret;
    }
}
