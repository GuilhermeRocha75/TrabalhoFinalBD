
package br.com.DAO;

import br.com.DTO.UsuarioDTO;
import java.sql.*;
import javax.swing.JOptionPane;


public class UsuarioDAO {
   
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
     //Metodo pesquisar
    public UsuarioDTO pesquisarUsuario(int idUsuario) {
        String sql = "SELECT * FROM tb_usuarios WHERE id_usuario = ?";
        conexao = new ConexaoDAO().conector();
        UsuarioDTO usuarioDTO = null;

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, idUsuario);
            rs = pst.executeQuery();

            // Se encontrar um usuário, cria o objeto UsuarioDTO com os dados
            if (rs.next()) {
                usuarioDTO = new UsuarioDTO();
                usuarioDTO.setIdUsuario(rs.getInt("id_usuario"));
                usuarioDTO.setNomeUsuario(rs.getString("usuario"));
                usuarioDTO.setLoginUsuario(rs.getString("login"));
                usuarioDTO.setSenhaUsuario(rs.getString("senha"));
            }

            rs.close();
            pst.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar usuário: " + e);
        }

        return usuarioDTO;
    }
    
    //Metodo inserir/adicionar usuarios
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
      //Metodo para virificar se usuario ou id ja existem
    public boolean verificarUsuarioExistente(int idUsuario, String loginUsuario) {
        String sql = "SELECT * FROM tb_usuarios WHERE id_usuario = ? OR login = ?";
        conexao = new ConexaoDAO().conector();
        boolean existe = false;

        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, idUsuario);
            pst.setString(2, loginUsuario);
            
            rs = pst.executeQuery();

            if (rs.next()) {
                existe = true;  // Se houver resultado, o usuário já existe
            }
            
            rs.close();
            pst.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar usuário existente: " + e);
        }

        return existe;
    }
    
    
    //Metodo editar
    public void editar(UsuarioDTO objUsarioDTO){
        String sql = "update tb_usuarios set usuario = ?, login = ?, senha = ? where id_usuario = ?";
         conexao = ConexaoDAO.conector();
         try {
               pst = conexao.prepareStatement(sql);
               pst.setInt(4, objUsarioDTO.getIdUsuario());
               pst.setString(1, objUsarioDTO.getNomeUsuario());
               pst.setString(2, objUsarioDTO.getLoginUsuario());
               pst.setString(3, objUsarioDTO.getSenhaUsuario());
               
               int add = pst.executeUpdate();
               if (add >0){
                   JOptionPane.showMessageDialog(null, "Usuário editado com sucesso!");
                    //pesquisaAuto();
                    conexao.close();
                    //limparCampos();
               }
               
            
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null," Método editar " + e);
        
        }
    }
    
    
    
    
    
    
}
