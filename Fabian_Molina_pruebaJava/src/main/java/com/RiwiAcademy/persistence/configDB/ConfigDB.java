package com.RiwiAcademy.persistence.configDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {

        private static Connection connection = null;

        public static Connection getConnection(){

            String URL = "jdbc:mysql://localhost:3306/RiwiAcademyDB";
            String user = "root";
            String password = "Rlwl2023.";

            try {
                connection = DriverManager.getConnection(URL,user,password);

                System.out.println("Connection successful");
            } catch (SQLException error){
                throw new RuntimeException(error.getMessage());
            }

            return  connection;
        }

        public static void closeConnection(){

            if (connection != null){
                try {
                    connection.close();

                    System.out.println("Connection closed");
                } catch (SQLException error){
                    throw new RuntimeException(error.getMessage());
                }
            }
        }
    }

