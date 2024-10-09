package org.example.servlet_demo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    Connection conn = null;

    public Connection openConnection() throws SQLException {
        try {
            String dbName = "classicmodels";
            String dbUsername = "root";
            String dbPassword = "";
            String url = "jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false";
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, dbUsername, dbPassword);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return conn;
    }

    public void closeConnection() throws SQLException {
        conn.close();
    }
}
