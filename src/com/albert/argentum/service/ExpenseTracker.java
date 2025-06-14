package com.albert.argentum.service;

import com.albert.argentum.model.Transaction;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import com.albert.argentum.ui.Screen;
import java.io.FileWriter;
import java.io.IOException;

public class ExpenseTracker {
    ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    String[] columns = {"Date", "Amount", "Concept"};

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
        int colSize = 15;
        //ADD FILTERING
        Map<String, Object> filters = Screen.promptFilters(columns);
        ArrayList<Transaction> filtered = filterTransactions(filters);
        transactions.sort(new Transaction.DateCompare());
        for (int i = 0; i < columns.length; ++i){
            System.out.print(Screen.tabline(columns[i], colSize)+"|");
        }
        System.out.println();
        for (int i = 0; i < 20 && i < transactions.size(); ++i){
            System.out.print(Screen.tabline(transactions.get(i).getDate().toString(), colSize) + " ");
            System.out.print(Screen.tabline(String.format("%.02f", transactions.get(i).getAmount()), colSize)+ " ");
            System.out.print(Screen.tabline(transactions.get(i).getConcept(), colSize)+ " ");
            System.out.println();
        }
        //System.out.println(this.toString());
    }

    private ArrayList<Transaction> filterTransactions(Map<String, Object> filters){
        return this.transactions;
    }

    public void exportCSV(){
        try{
            FileWriter csv = new FileWriter("transactions.csv");
            for (int i = 0; i < columns.length; ++i){
                csv.write(columns[i]);
                if (i == columns.length - 1)
                    csv.write("\n");
                else
                    csv.write(",");
            }
            csv.write(this.toString());
            csv.close();
            System.out.println("File transactions.csv generated successfully");
        }catch (IOException e) {
            System.out.println("Error exporting to CSV: " + e.getCause());
        }

    }

    @Override
    public String toString(){
        String ret = "";
        for (Transaction t : this.transactions){
           ret += t.toString()+"\n"; 
        }
        return ret;
    }
}
