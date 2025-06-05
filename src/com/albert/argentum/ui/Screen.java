
package com.albert.argentum.ui;
import java.util.Scanner;

public class Screen{

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("=== Argentum ===");
    }
     
    public static void wrongInput(){
        System.out.println("Invalid option.");
    }

}
