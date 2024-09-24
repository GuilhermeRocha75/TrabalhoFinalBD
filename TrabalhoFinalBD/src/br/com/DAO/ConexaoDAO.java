
package br.com.DAO;

import java.sql.Connection;
import java.sql.*;
import javax.swing.JOptionPane;

public class ConexaoDAO {
    
    public static Connection conector(){
        java.sql.Connection conexao = null;
        
        String driver = "com.mysql.cj.jdbc.Driver";
        
        String url = "jdbc:mysql://localhost:3306/trabalhofinalb";
        String user = "root";
        String password = "root";
        
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Conexão" +e);
            return null;
        }
    }
    
}