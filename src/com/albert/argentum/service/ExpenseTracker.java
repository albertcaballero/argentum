package com.albert.argentum.service;

import com.albert.argentum.model.Transaction;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import com.albert.argentum.ui.Screen;

public class ExpenseTracker {
    ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public ExpenseTracker(){
        for (int i=0; i < 5; ++i){
            Transaction tr = new Transaction("2025-02-1"+i, "holi"+i, i);
            this.transactions.add(tr);
        }
    }

    public void addTransaction(Scanner scanner){
        System.out.print("\n");
        System.out.println("= Add transaction =");
        System.out.print("Date> ");
        String d = scanner.nextLine();

        System.out.print("Amount> ");
        float a = Float.parseFloat(scanner.nextLine());

        System.out.print("Concept> ");
        String c = scanner.nextLine();

        Transaction t = new Transaction(d, c, a);
        transactions.add(t);
    }

    public void viewTransactions(){
        transactions.sort(new Transaction.DateCompare());
        System.out.println("Date      |  Amount  | Concept       |");
        for (int i = 0; i < 20 || i < transactions.size(); ++i){
            System.out.println(Screen.tabline(transactions.get(i).getDate().toString(), 4));
        }
        //System.out.println(this.toString());
    }

    public void exportCSV(){
    }

    @Override
    public String toString(){
        String ret = "";
        for (Transaction t : this.transactions){
           ret += t.toString()+"; "; 
        }
        return ret;
    }
}
