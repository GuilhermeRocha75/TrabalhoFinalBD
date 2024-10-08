/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.VIEWS;

import br.com.DAO.ConexaoDAO;
import br.com.DAO.UsuarioDAO;
import br.com.DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Colégio São Lucas Ulbra <Universidade Luterana do brasil>
 */
public class TelaUsuarios extends javax.swing.JInternalFrame {

    Connection conexao = null;
   PreparedStatement pst = null;
   ResultSet rs = null;
    
    /**
     * Creates new form TelaUsuarios2
     */
    public TelaUsuarios() {
        initComponents();
        conexao = ConexaoDAO.conector();
    }

     
    
   
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIncluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        txtIdUsuario = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNomeUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnLimpar = new javax.swing.JButton();
        txtLoginUsuario = new javax.swing.JTextField();
        txtSenhaUsuario = new javax.swing.JPasswordField();
        btnExcluir1 = new javax.swing.JButton();

        setClosable(true);

        btnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconeAdd.png"))); // NOI18N
        btnIncluir.setText("incluir");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ID:");

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconeEditar.png"))); // NOI18N
        btnEditar.setText("editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconePesquisar.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        txtIdUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdUsuarioActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Nome:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Login:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Senha:");

        btnLimpar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/iconeLimpar.png"))); // NOI18N
        btnLimpar.setText("Limpar");
        btnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparActionPerformed(evt);
            }
        });

        txtLoginUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginUsuarioActionPerformed(evt);
            }
        });

        btnExcluir1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/IconeExcluir.png"))); // NOI18N
        btnExcluir1.setText("excluir");
        btnExcluir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluir1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnPesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIncluir))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtLoginUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNomeUsuario, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSenhaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtIdUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(btnEditar)
                        .addGap(36, 36, 36)
                        .addComponent(btnExcluir1)
                        .addGap(67, 67, 67)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIdUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNomeUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLoginUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4)
                    .addComponent(txtSenhaUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluir1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
        
        
    // Verifique se qualquer um dos campos obrigatórios está vazio
    if (txtIdUsuario.getText().trim().isEmpty() || txtLoginUsuario.getText().trim().isEmpty()) {
        // Exibe mensagem de erro se qualquer um dos campos estiver vazio
        JOptionPane.showMessageDialog(null, "Preencha todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
    } else {
        // Captura de dados na tela Usuario
        int id_Usuario = Integer.parseInt(txtIdUsuario.getText());
        String nome_Usuario = txtNomeUsuario.getText();
        String login_Usuario = txtLoginUsuario.getText();
        String senha_Usuario = txtSenhaUsuario.getText();
        
        
        UsuarioDAO objUsuarioDAO = new UsuarioDAO();

        // Verifica se o id ou login já existem
        if (objUsuarioDAO.verificarUsuarioExistente(id_Usuario, login_Usuario)) {
            JOptionPane.showMessageDialog(null, "O ID ou login já estão cadastrados!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            // Se não existir, insere o novo usuário
            UsuarioDTO objUsuarioDTO = new UsuarioDTO();
            objUsuarioDTO.setIdUsuario(id_Usuario);
            objUsuarioDTO.setNomeUsuario(nome_Usuario);
            objUsuarioDTO.setLoginUsuario(login_Usuario);
            objUsuarioDTO.setSenhaUsuario(senha_Usuario);

            objUsuarioDAO.inserirUsuario(objUsuarioDTO);
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            
        }
    }

        
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        // Chamada do metodo Pesquisar
        
        // Obtém o ID do campo de texto
    int idUsuario = Integer.parseInt(txtIdUsuario.getText());

    // Cria uma instância do DAO
    UsuarioDAO usuarioDAO = new UsuarioDAO();

    // Chama o método pesquisar e obtém o resultado
    UsuarioDTO usuarioDTO = usuarioDAO.pesquisarUsuario(idUsuario);

    if (usuarioDTO != null) {
        // Preenche os campos com os dados do usuário encontrado
        txtNomeUsuario.setText(usuarioDTO.getNomeUsuario());
        txtLoginUsuario.setText(usuarioDTO.getLoginUsuario());
        txtSenhaUsuario.setText(usuarioDTO.getSenhaUsuario());
    } else {
        // Mostra uma mensagem de erro se o usuário não for encontrado
        JOptionPane.showMessageDialog(null, "Usuário não cadastrado!");

        //metodo para apagar os campos
         UsuarioDAO objUsuarioDAO = new UsuarioDAO();       
            objUsuarioDAO.limpar();
    }

    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void txtIdUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdUsuarioActionPerformed

    private void btnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparActionPerformed
        //metodo botao limpar
          
       UsuarioDAO objUsuarioDAO = new UsuarioDAO();       
            objUsuarioDAO.limpar();
    }//GEN-LAST:event_btnLimparActionPerformed

    private void txtLoginUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLoginUsuarioActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        
       //Botao editar(msm codigo btn inlcuir)
        int id_usuario = Integer.parseInt(txtIdUsuario.getText());
        String nome_usuario = txtNomeUsuario.getText();
        String login_usuario = txtLoginUsuario.getText();
        String senha_usuario = txtSenhaUsuario.getText();


        UsuarioDTO objusuarioDTO = new UsuarioDTO();
        objusuarioDTO.setIdUsuario (id_usuario);
        objusuarioDTO.setNomeUsuario (nome_usuario);
        objusuarioDTO.setLoginUsuario (login_usuario);
        objusuarioDTO.setSenhaUsuario(senha_usuario);

            UsuarioDAO objUsuarioDAO = new UsuarioDAO();       
            objUsuarioDAO.editar(objusuarioDTO);
        
        
    
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluir1ActionPerformed
        // TODO add your handling code here:
        
        String idUsuario = txtIdUsuario.getText();
        
        UsuarioDTO objUsuarioDTO = new UsuarioDTO();
        objUsuarioDTO.setIdUsuario(Integer.parseInt(idUsuario));
        
        UsuarioDAO objUsuarioDAO = new UsuarioDAO();
        objUsuarioDAO.excluir(objUsuarioDTO);
     
        
    }//GEN-LAST:event_btnExcluir1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir1;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    public static javax.swing.JTextField txtIdUsuario;
    public static javax.swing.JTextField txtLoginUsuario;
    public static javax.swing.JTextField txtNomeUsuario;
    public static javax.swing.JPasswordField txtSenhaUsuario;
    // End of variables declaration//GEN-END:variables
}
