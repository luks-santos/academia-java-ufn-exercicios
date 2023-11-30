package org.ufn.jbdc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    public static Connection connect(boolean autoCommit){
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "postgres";
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(autoCommit);
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
