package org.ufn.jdbc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    
    public DB(){
    }
    
    public static Connection connect(){
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "postgres";
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
