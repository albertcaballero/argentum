package com.albert.argentum.model;

import java.time.LocalDate;
import java.util.Comparator;

public class Transaction {
    private int id;
    private LocalDate date;
    private String concept;
    private float amount;

    public Transaction(String date, String concept, float amount){
        this.date = LocalDate.parse(date);
        this.concept=concept;
        this.amount = amount;
    }

    public void loadTransaction(){
    }

    public void saveTransaction(){
    }

    /* Getters */
    public LocalDate getDate(){return date;}
    public float getAmount(){return amount;}
    public String getConcept(){return concept;}


    @Override
    public String toString(){
        return this.date.toString() +","+this.concept+"," + this.amount;
    }

    public static class DateCompare implements Comparator<Transaction>{
        public int compare(Transaction t1, Transaction t2){
            return t1.getDate().compareTo(t2.getDate());
        }
    }
}


