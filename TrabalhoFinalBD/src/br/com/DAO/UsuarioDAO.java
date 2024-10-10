
package br.com.DAO;

import br.com.DTO.UsuarioDTO;
import br.com.VIEWS.TelaPrincipal;
import br.com.VIEWS.TelaUsuarios;
import java.sql.*;
import javax.swing.JOptionPane;


public class UsuarioDAO {
   
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
  /* public void logar(UsuarioDTO objUsuarioDTO){
        String sql = "select * from tb_usuarios where login = ? and senha = ?";
        
        try {
            //preparar a cosulta no banco, em função do que foi inserido nas caixas de texto
            pst = conexao.prepareStatement(sql);
            pst.setString(1,objUsuarioDTO.getLoginUsuario());
            pst.setString(2, objUsuarioDTO.getSenhaUsuario());
            
            //executar a query
            rs = pst.executeQuery();
            
            if (rs.next()){
               String perfil = rs.getString(5);
               
               if (perfil.equals("admin")){
                   TelaPrincipal principal = new TelaPrincipal();
                   principal.setVisible(true);
                   TelaPrincipal.MenuRel.setEnabled(true);
                   TelaPrincipal.subMenuUsuarios.setEnabled(true);
                   TelaPrincipal.
               }
               
                       }else {
                JOptionPane.showMessageDialog(null, "Usuario e/ou senha inválidos");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Tela de login"+ e);
            
        }
   }
    */
   
   
   
     public void limpar(){
        TelaUsuarios.txtIdUsuario.setText(null);
        TelaUsuarios.txtNomeUsuario.setText(null);
        TelaUsuarios.txtSenhaUsuario.setText(null);
        TelaUsuarios.txtLoginUsuario.setText(null);
    }
    
    
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
             limpar();
            
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
               pst.setString(1, objUsarioDTO.getNomeUsuario());
               pst.setString(2, objUsarioDTO.getLoginUsuario());
               pst.setString(3, objUsarioDTO.getSenhaUsuario());
                pst.setInt(4, objUsarioDTO.getIdUsuario());
                
               int add = pst.executeUpdate();
               if (add >0){
                   JOptionPane.showMessageDialog(null, "Usuário editado com sucesso!");
                    //pesquisaAuto();
                    conexao.close();
                    limpar();
               }
               
            
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null," Método editar " + e);
        
        }
    }
    
    //Metodo Excluir
    public void excluir (UsuarioDTO objUsuarioDTO){
        String sql = "delete from tb_usuarios where id_usuario = ?";
        conexao = ConexaoDAO.conector();
        
        try {
              pst = conexao.prepareStatement(sql);
              pst.setInt(1, objUsuarioDTO.getIdUsuario());
            
                    int add = pst.executeUpdate();
                    if (add >0){
                    JOptionPane.showMessageDialog(null, "Usuário excluido com sucesso!");
                    //pesquisaAuto();
                    conexao.close();
                   limpar();
               }
              
                      } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Método apagar" +e);
        }
        
    }
    
    
    
    
    
    
}
