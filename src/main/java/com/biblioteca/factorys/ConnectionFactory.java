package com.biblioteca.factorys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
    private static final String ROOT =  "root";
    private static final String PASSWORD= "vZGLFK70";

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(URL, ROOT, PASSWORD);
        }catch (SQLException e){
            throw new RuntimeException("Erro ao conectar no banco", e);
        }
    }
}
