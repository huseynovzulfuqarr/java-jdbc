package org.example.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection=null;

    public static Connection getConnection()  {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
       try {
           connection = DriverManager
                   .getConnection("jdbc:mysql://localhost:3306/db", "root", "password");
           System.out.println("qoshuldu");
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
       return connection;
    }

    public static void closeConnection() throws Exception{
        connection.close();
    }

}
