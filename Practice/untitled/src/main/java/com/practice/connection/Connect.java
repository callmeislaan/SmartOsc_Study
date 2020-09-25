package com.practice.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/practice_student_management_system";
        Connection connection = DriverManager.getConnection(url, "root", "");
        return connection;
    }
}
