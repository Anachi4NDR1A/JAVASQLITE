/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author ANDRIANANTENAINA
 */
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection {
    public static Connection connect() {
        try {
            Class.forName("org.sqlite.JDBC");

            // Use ClassLoader to get the resource URL
            URL url = SQLiteConnection.class.getClassLoader().getResource("javaapplication1/base/base.db");

            if (url == null) {
                throw new SQLException("Database file not found in the classpath.");
            }

            String dbPath = url.getPath();
            String dbUrl = "jdbc:sqlite:" + dbPath;

            Connection conn = DriverManager.getConnection(dbUrl);
            return conn;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
