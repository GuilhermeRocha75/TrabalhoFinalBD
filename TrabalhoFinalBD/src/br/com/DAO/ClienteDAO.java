
package br.com.DAO;

import br.com.DTO.ClienteDTO;
import br.com.DTO.UsuarioDTO;
import br.com.VIEWS.TelaCliente;
import br.com.VIEWS.TelaPrincipal;
import br.com.VIEWS.TelaUsuarios;
import java.awt.Color;
import java.sql.*;
import javax.swing.JOptionPane;


public class ClienteDAO {
   
    
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    // Método para verificar login
    public boolean logar(String login, String senha) {
        String sql = "SELECT * FROM tb_clientes WHERE login = ? AND senha = ?";
        conexao = new ConexaoDAO().conector(); // Conecta ao banco de dados

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, login);
            pst.setString(2, senha);

            rs = pst.executeQuery();

            if (rs.next()) {
                // Login e senha corretos
                return true;
            }

            rs.close();
            pst.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro no login: " + e);
        }

        return false; // Login ou senha inválidos
    }
   
   
   
public void limpar() {
    TelaCliente.txtIdUsuario.setText(null);
    TelaCliente.txtNomeUsuario.setText(null);
    TelaCliente.txtTelefone.setText(null);
    TelaCliente.txtEndereco.setText(null);
}

    
    
     //Metodo pesquisar
    public UsuarioDTO pesquisarUsuario(int idUsuario) {
        String sql = "SELECT * FROM tb_clientes WHERE id_usuario = ?";
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
    public void inserirUsuario(ClienteDTO objClienteDTO){
        String sql = "insert into tb_clientes(id_usuario, usuario, login, senha) values(?, ?, ?, ?)";
        conexao = new ConexaoDAO().conector();
        
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1,objClienteDTO.getIdUsuario());
            pst.setString(2,objClienteDTO.getNomeUsuario());
            pst.setString(3, objClienteDTO.getLoginUsuario());
            pst.setString(4, objClienteDTO.getSenhaUsuario());
            
            pst.execute();
            pst.close();
             limpar();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Inserir Usuario:" + e);
        }

    }   
      //Metodo para virificar se usuario ou id ja existem
    public boolean verificarUsuarioExistente(int idUsuario, String loginUsuario) {
        String sql = "SELECT * FROM tb_clientes WHERE id_usuario = ? OR login = ?";
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
    
    
    // Método editar
public void editar(ClienteDTO objClienteDTO) {
    String sql = "UPDATE tb_clientes SET usuario = ?, login = ?, senha = ? WHERE id_usuario = ?";
    conexao = ConexaoDAO.conector();
    try {
        pst = conexao.prepareStatement(sql);
        pst.setString(1, objClienteDTO.getNomeUsuario());
        pst.setString(2, objClienteDTO.getLoginUsuario());
        pst.setString(3, objClienteDTO.getSenhaUsuario());
        pst.setInt(4, objClienteDTO.getIdUsuario());
        
        int add = pst.executeUpdate();
        if (add > 0) {
            JOptionPane.showMessageDialog(null, "Cliente editado com sucesso!");
            // pesquisaAuto(); // Se essa função for necessária, mantenha-a
            conexao.close();
            limpar(); // Limpa os campos
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Método editar: " + e);
    }
}

    
  // Método Excluir
public void excluir(ClienteDTO objClienteDTO) {
    String sql = "delete from tb_clientes where id_usuario = ?";
    conexao = ConexaoDAO.conector();
    
    try {
        pst = conexao.prepareStatement(sql);
        pst.setInt(1, objClienteDTO.getIdUsuario());
        
        int add = pst.executeUpdate();
        if (add > 0) {
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
            // pesquisaAuto();
            conexao.close();
            limpar();
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Método excluir: " + e);
    }
}


    
    
    
    
    
    
    
}
