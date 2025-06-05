package com.albert.argentum.model;

import java.util.Date;

public class Transaction {
    Date date;
    String concept;
    float amount;


    public Transaction(String date, String concept, float amount){
        this.date = new Date(date);
        this.concept=concept;
        this.amount = amount;
    }

    public void loadTransaction(){
    }

    public void saveTransaction(){
    }
}
