
package com.albert.argentum.database;

import java.sql.*;

public class Database {
    Connection conn;

    public Database(){
        String path = "jdbc:sqlite:resources/argentum.db";
        try {
            conn = DriverManager.getConnection(path);
            setup();
        } catch (SQLException e){
            System.out.println("Couldn't connect to database");
        }
    }

    private void setup(){
        try (Statement stm = conn.createStatement()){
            stm.executeUpdate("Create table if not exists transactions (" +
                " id INTEGER PRIMARY KEY, " +
                " date TEXT, concept TEXT, amount REAL );");
        } catch (SQLException e){
            System.out.println("Couldn't create table");
        }
    }

    public void insertOrUpdate(String sql){
        try (Statement stm = conn.createStatement()){
            stm.executeUpdate(sql);
        } catch (SQLException e){
            System.out.println("Couldn't insert/update \""+sql+"\"");
        }
         
    }

}
