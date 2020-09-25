package org.example;

import java.sql.*;

public class Controller {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/testjdbc";
        Connection conn = null;
        return DriverManager.getConnection(url, "root", "");
    }

    public static boolean executeNonQuery(String sql) throws SQLException {
        Statement statement = getConnection().createStatement();
        return statement.executeUpdate(sql) != 0;
    }

    public static ResultSet executeQuery(String sql) throws SQLException {
        Statement statement = getConnection().createStatement();
        return statement.executeQuery(sql);
    }
}
