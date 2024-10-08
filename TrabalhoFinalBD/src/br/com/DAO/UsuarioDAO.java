
package br.com.DAO;

import br.com.DTO.UsuarioDTO;
import java.sql.*;
import javax.swing.JOptionPane;


public class UsuarioDAO {
   
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    
    public void inserirUsuario(UsuarioDTO objUsuarioDTO){
        String sql = "insert into tb_usuarios(id_usuario, usuario, login, senha) values(?, ?, ?, ?)";
        conexao = new ConexaoDAO().conector();
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, objUsuarioDTO.getIdUsuario());
            pst.setString(2, objUsuarioDTO.getNomeUsuario());
            pst.setString(3, objUsuarioDTO.getLoginUsuario());
            pst.setString(4, objUsuarioDTO.getSenhaUsuario());
            
            pst.execute();
            pst.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Inserir Usuario:" + e);
        }

    }   
    
    
}
