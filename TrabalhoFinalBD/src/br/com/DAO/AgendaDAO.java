package br.com.DAO;

import br.com.DTO.AgendaDTO;
import br.com.VIEWS.TelaAgenda;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class AgendaDAO {

    Connection conexao = null;  // Conexão com o banco de dados
    PreparedStatement pst = null;  // Comando SQL preparado
    ResultSet rs = null;  // Para armazenar o resultado da consulta

    public List<AgendaDTO> listarCompromissos() {
        List<AgendaDTO> compromissos = new ArrayList<>();
        String sql = "SELECT * FROM tb_agenda";  // SQL para listar os compromissos

        try {
            // Estabelece a conexão com o banco de dados
            conexao = new ConexaoDAO().conector();

            // Prepara a consulta SQL
            pst = conexao.prepareStatement(sql);

            // Executa a consulta e inicializa o ResultSet com os resultados
            rs = pst.executeQuery();

            // Itera sobre o ResultSet e adiciona cada registro à lista de compromissos
            while (rs.next()) {
                AgendaDTO agenda = new AgendaDTO();
                agenda.setId(rs.getInt("id"));
                agenda.setData(rs.getDate("data").toLocalDate());
                agenda.setHora(rs.getTime("hora").toLocalTime());
                agenda.setDescricao(rs.getString("descricao"));
                agenda.setClienteId(rs.getInt("cliente_id"));

                compromissos.add(agenda);
            }

            // Fecha o ResultSet e o PreparedStatement
            rs.close();
            pst.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar compromissos: " + e);
        }

        return compromissos;
    }
    
    // Método para adicionar um compromisso
    public void adicionarCompromisso(AgendaDTO agenda) {
        String sql = "INSERT INTO tb_agenda (data, hora, descricao, cliente_id) VALUES (?, ?, ?, ?)";

        try {
            // Estabelece a conexão com o banco de dados
            conexao = new ConexaoDAO().conector();

            // Prepara a consulta SQL
            pst = conexao.prepareStatement(sql);

            // Define os parâmetros do PreparedStatement
            pst.setDate(1, java.sql.Date.valueOf(agenda.getData()));  // Data no formato LocalDate
            pst.setTime(2, java.sql.Time.valueOf(agenda.getHora()));  // Hora no formato LocalTime
            pst.setString(3, agenda.getDescricao());  // Descrição
            pst.setInt(4, agenda.getClienteId());  // ID do cliente associado

            // Executa a inserção no banco de dados
            pst.executeUpdate();

            // Mensagem de sucesso
            JOptionPane.showMessageDialog(null, "Compromisso adicionado com sucesso!");

            // Fecha o PreparedStatement
            pst.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar compromisso: " + e);
        }
    }


    
   public void limpar() {
       TelaAgenda.txtData.setText(null);
       TelaAgenda.txtCliente.setText(null);
       TelaAgenda.txtDescricao.setText(null);
       TelaAgenda.txtHora.setText(null);
}

}


