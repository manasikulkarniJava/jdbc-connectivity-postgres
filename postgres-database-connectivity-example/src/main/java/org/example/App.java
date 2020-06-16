package org.example;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class App {
    public static void main(String[] args) {
        try {
            System.out.println("Welcome to postgres SQL");

            //Diver for postgresql
            Class.forName("org.postgresql.Driver");

            //1.URL
            //2.User Name
            //3.Password
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "postgres");
            System.out.println("Connection Successful !!");

            //Write the query to be executed
            //training is table name
            PreparedStatement stmt = con.prepareStatement("select * from training;");
            ResultSet set = stmt.executeQuery();
            System.out.println("Query Execution Successful !!");

            //Loop through table using column number or column name
            while (set.next()) {
                System.out.println(set.getString("id") + "|" + set.getString("name") + "|" + set.getInt("durationindays") + "|" + set.getString(4));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
