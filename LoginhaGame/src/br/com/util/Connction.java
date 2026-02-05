package br.com.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jesus
 */
public class Connction {
    // endereço doi banco
    private static final String URL = "jdbc:mysql://localhost:3306/LoginhaGame";
    //usuario do MySQL 
    private static final String USER = "root"; 
    // senha do MySQL 
    private static final String PASS = "root";
    // Métodos que desenvolver uma conexão pronta 
    public static Connection getConnection() throws SQLException{
        // abre a conexão e retorna parea quem chamou 
        try {
        return DriverManager.getConnection(URL, USER, PASS);
        
        } catch (Exception e) {
            throw new RuntimeException("Erro ao cocbetar-se ao banco" + e.getMessage());
        }
    }
}
