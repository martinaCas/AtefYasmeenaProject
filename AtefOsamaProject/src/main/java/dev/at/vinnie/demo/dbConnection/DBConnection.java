package dev.at.vinnie.demo.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
        private static final String URL = "jdbc:mysql://localhost:3306/products";
        private static final String USER = "root";
        private static final String PASSWORD = "martina";

        static {
            try {
                Class.forName( "com.mysql.cj.Driver" );
            } catch (ClassNotFoundException e){
                throw new RuntimeException("Connection not established",e);
            }
        }
        private DBConnection(){};

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection( URL, USER, PASSWORD );
        }

}
