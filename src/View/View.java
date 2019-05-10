/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.*;
import Modal.Funcionario;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class View extends javax.swing.JFrame {
        JCaixa caixa;
        ConectionFactory con;
        FuncionarioDao funDao;
        Funcionario f1;
    
    public View(Funcionario fun) throws Exception{        
        con = new ConectionFactory();
        con.Conection();       
        f1 = new Funcionario();
        f1 = fun;initComponents();
        initComponents();
        Inicializacao();
    }
    public View(){        
    }
    private void Inicializacao(){
        jPanelCorpoBase.setVisible(true);
        Btn(false, false, false);                        
        jNomeFunc.setText(f1.getNome());
        jPermissao.setText(String.valueOf(f1.getMatricula()));
    }
    
    private void Btn(boolean btnFunc, boolean btnEstoq, boolean btnCad){        
        jPanelBaseEstoque.setVisible(btnEstoq);
        jPanelBaseCadProd.setVisible(btnCad);
        jPanelBaseFuncionario.setVisible( btnFunc);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMenu = new javax.swing.JPanel();
        jBtnCaixa = new javax.swing.JButton();
        jBtnEstoque = new javax.swing.JButton();
        jBtnGrafico = new javax.swing.JButton();
        jBtnEntradaProd = new javax.swing.JButton();
        jNomeFunc = new javax.swing.JLabel();
        jPermissao = new javax.swing.JLabel();
        jPanelCorpoBase = new javax.swing.JPanel();
        jLayeredPaneEstoque = new javax.swing.JLayeredPane();
        jPanelBaseEstoque = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLayeredPaneCadProd = new javax.swing.JLayeredPane();
        jPanelBaseCadProd = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTxtCodBarras = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTxtNmProd = new javax.swing.JTextField();
        jTxtQteProd = new javax.swing.JTextField();
        jTxtVlrCompra = new javax.swing.JTextField();
        jTxtVlrVenda = new javax.swing.JTextField();
        jLayeredPaneFuncionario = new javax.swing.JLayeredPane();
        jPanelBaseFuncionario = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jTxtNome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jTxtMatricula = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jBtnCadastrar = new javax.swing.JButton();
        jBtnDeletar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Caixas");

        jPanelMenu.setBackground(new java.awt.Color(153, 153, 255));

        jBtnCaixa.setText("Caixa");
        jBtnCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCaixaActionPerformed(evt);
            }
        });

        jBtnEstoque.setText("Estoque");
        jBtnEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEstoqueActionPerformed(evt);
            }
        });

        jBtnGrafico.setText("Cadastros funcionario");
        jBtnGrafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGraficoActionPerformed(evt);
            }
        });

        jBtnEntradaProd.setText("Entrada/cadastro de produto");
        jBtnEntradaProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEntradaProdActionPerformed(evt);
            }
        });

        jNomeFunc.setText("nome");

        jPermissao.setText("permissao");

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnEntradaProd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnGrafico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnEstoque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnCaixa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelMenuLayout.createSequentialGroup()
                        .addComponent(jNomeFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPermissao, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnEntradaProd, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNomeFunc)
                    .addComponent(jPermissao))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanelCorpoBase.setBackground(new java.awt.Color(204, 255, 0));

        jLayeredPaneEstoque.setBackground(new java.awt.Color(255, 255, 255));

        jPanelBaseEstoque.setBackground(new java.awt.Color(0, 51, 204));
        jPanelBaseEstoque.setLayout(new java.awt.BorderLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanelBaseEstoque.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jLayeredPaneEstoqueLayout = new javax.swing.GroupLayout(jLayeredPaneEstoque);
        jLayeredPaneEstoque.setLayout(jLayeredPaneEstoqueLayout);
        jLayeredPaneEstoqueLayout.setHorizontalGroup(
            jLayeredPaneEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPaneEstoqueLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelBaseEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jLayeredPaneEstoqueLayout.setVerticalGroup(
            jLayeredPaneEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPaneEstoqueLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelBaseEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jLayeredPaneEstoque.setLayer(jPanelBaseEstoque, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPaneCadProd.setBackground(new java.awt.Color(255, 255, 255));

        jPanelBaseCadProd.setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setText("Codigo de Barras: ");

        jTxtCodBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtCodBarrasActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome Produto: ");

        jLabel3.setText("Valor Compra: ");

        jLabel4.setText("Quantidade: ");

        jLabel5.setText("Valor Venda: ");

        jTxtQteProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtQteProdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBaseCadProdLayout = new javax.swing.GroupLayout(jPanelBaseCadProd);
        jPanelBaseCadProd.setLayout(jPanelBaseCadProdLayout);
        jPanelBaseCadProdLayout.setHorizontalGroup(
            jPanelBaseCadProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBaseCadProdLayout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(jPanelBaseCadProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelBaseCadProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTxtCodBarras)
                    .addComponent(jTxtNmProd)
                    .addComponent(jTxtQteProd)
                    .addComponent(jTxtVlrCompra)
                    .addComponent(jTxtVlrVenda, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanelBaseCadProdLayout.setVerticalGroup(
            jPanelBaseCadProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBaseCadProdLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanelBaseCadProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtCodBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBaseCadProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtNmProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBaseCadProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtQteProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBaseCadProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtVlrCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBaseCadProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTxtVlrVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(307, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jLayeredPaneCadProdLayout = new javax.swing.GroupLayout(jLayeredPaneCadProd);
        jLayeredPaneCadProd.setLayout(jLayeredPaneCadProdLayout);
        jLayeredPaneCadProdLayout.setHorizontalGroup(
            jLayeredPaneCadProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBaseCadProd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jLayeredPaneCadProdLayout.setVerticalGroup(
            jLayeredPaneCadProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBaseCadProd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jLayeredPaneCadProd.setLayer(jPanelBaseCadProd, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanelBaseFuncionario.setBackground(new java.awt.Color(153, 255, 153));

        jLabel6.setText("nome: ");

        jTxtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtNomeActionPerformed(evt);
            }
        });

        jLabel7.setText("senha: ");

        jLabel8.setText("Matriula: ");

        jCheckBox1.setText("Permissão de cancelamento de compras.");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jBtnCadastrar.setText("Cadastrar");
        jBtnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadastrarActionPerformed(evt);
            }
        });

        jBtnDeletar.setText("Deletar");
        jBtnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBaseFuncionarioLayout = new javax.swing.GroupLayout(jPanelBaseFuncionario);
        jPanelBaseFuncionario.setLayout(jPanelBaseFuncionarioLayout);
        jPanelBaseFuncionarioLayout.setHorizontalGroup(
            jPanelBaseFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBaseFuncionarioLayout.createSequentialGroup()
                .addGroup(jPanelBaseFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBaseFuncionarioLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanelBaseFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBaseFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7)
                                .addComponent(jLabel6))
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelBaseFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTxtMatricula, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(jTxtNome)
                            .addComponent(jPassword)))
                    .addGroup(jPanelBaseFuncionarioLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addGroup(jPanelBaseFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelBaseFuncionarioLayout.createSequentialGroup()
                                .addComponent(jBtnCadastrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnDeletar))
                            .addComponent(jCheckBox1))))
                .addContainerGap(590, Short.MAX_VALUE))
        );
        jPanelBaseFuncionarioLayout.setVerticalGroup(
            jPanelBaseFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBaseFuncionarioLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanelBaseFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBaseFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelBaseFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTxtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox1)
                .addGap(27, 27, 27)
                .addGroup(jPanelBaseFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnCadastrar)
                    .addComponent(jBtnDeletar))
                .addContainerGap(339, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jLayeredPaneFuncionarioLayout = new javax.swing.GroupLayout(jLayeredPaneFuncionario);
        jLayeredPaneFuncionario.setLayout(jLayeredPaneFuncionarioLayout);
        jLayeredPaneFuncionarioLayout.setHorizontalGroup(
            jLayeredPaneFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBaseFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jLayeredPaneFuncionarioLayout.setVerticalGroup(
            jLayeredPaneFuncionarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBaseFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jLayeredPaneFuncionario.setLayer(jPanelBaseFuncionario, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jPanelCorpoBaseLayout = new javax.swing.GroupLayout(jPanelCorpoBase);
        jPanelCorpoBase.setLayout(jPanelCorpoBaseLayout);
        jPanelCorpoBaseLayout.setHorizontalGroup(
            jPanelCorpoBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPaneEstoque)
            .addGroup(jPanelCorpoBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLayeredPaneCadProd))
            .addGroup(jPanelCorpoBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLayeredPaneFuncionario))
        );
        jPanelCorpoBaseLayout.setVerticalGroup(
            jPanelCorpoBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPaneEstoque)
            .addGroup(jPanelCorpoBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLayeredPaneCadProd, javax.swing.GroupLayout.Alignment.TRAILING))
            .addGroup(jPanelCorpoBaseLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLayeredPaneFuncionario))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelCorpoBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelCorpoBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1126, 578));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtQteProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtQteProdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtQteProdActionPerformed

    private void jBtnCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCaixaActionPerformed
        // TODO add your handling code here:
        if(f1.isPermissao()){            
            caixa =  new JCaixa(f1);
            this.dispose();
            caixa.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null,"");
        }
    }//GEN-LAST:event_jBtnCaixaActionPerformed

    private void jBtnEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEstoqueActionPerformed
        // TODO add your handling code here
        Btn(false, true, false);
    }//GEN-LAST:event_jBtnEstoqueActionPerformed

    private void jBtnEntradaProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEntradaProdActionPerformed
        // TODO add your handling code here:
        Btn(false, false, true);
    }//GEN-LAST:event_jBtnEntradaProdActionPerformed

    private void jTxtCodBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCodBarrasActionPerformed
        // TODO add your handling code here:
                
                
        
    }//GEN-LAST:event_jTxtCodBarrasActionPerformed

    private void jBtnGraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGraficoActionPerformed
        // TODO add your handling code here:
        Btn(true, false, false);
    }//GEN-LAST:event_jBtnGraficoActionPerformed

    private void jBtnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadastrarActionPerformed
        // TODO add your handling code here:
        if(f1.isPermissao()){
            try {
                Funcionario newFunc = new Funcionario();
                funDao = new FuncionarioDao();
                newFunc.setNome(jTxtNome.getText());
                newFunc.setSenha(jPassword.getText());
                newFunc.setMatricula(Integer.parseInt(jTxtMatricula.getText()));
                jCheckBox1.getAction();
                newFunc.setPermissao(jCheckBox1.getHideActionText());
                funDao.cadastrar(newFunc);
                JOptionPane.showMessageDialog(null, "Cadastro realizada com sucesso");
            } catch (Exception ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
            jTxtNome.setText(null);
            jTxtMatricula.setText(null);
            jPassword.setText(null);
            jCheckBox1.setDropTarget(getDropTarget());
            
        }
    }//GEN-LAST:event_jBtnCadastrarActionPerformed

    private void jTxtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtNomeActionPerformed
            try {
                // TODO add your handling code here:
                funDao = new FuncionarioDao();
                jTxtMatricula.setText(funDao.Busca(jTxtNome.getText()));
            } catch (Exception ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
    }//GEN-LAST:event_jTxtNomeActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jBtnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeletarActionPerformed
        // TODO add your handling code here
        if(f1.isPermissao()){
            try {
                Funcionario newFunc = new Funcionario();
                funDao = new FuncionarioDao();
                newFunc.setNome(jTxtNome.getText());
                newFunc.setSenha(jPassword.getText());
                newFunc.setMatricula(Integer.parseInt(jTxtMatricula.getText()));
                newFunc.setPermissao(jCheckBox1.getHideActionText());
                funDao.Deletar(newFunc);
                JOptionPane.showMessageDialog(null, "Cadastro realizada com sucesso");
            } catch (Exception ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
            jTxtNome.setText(null);
            jTxtMatricula.setText(null);
            jPassword.setText(null);
            jCheckBox1.setDropTarget(getDropTarget());  
        }
    }//GEN-LAST:event_jBtnDeletarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new View().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCadastrar;
    private javax.swing.JButton jBtnCaixa;
    private javax.swing.JButton jBtnDeletar;
    private javax.swing.JButton jBtnEntradaProd;
    private javax.swing.JButton jBtnEstoque;
    private javax.swing.JButton jBtnGrafico;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPaneCadProd;
    private javax.swing.JLayeredPane jLayeredPaneEstoque;
    private javax.swing.JLayeredPane jLayeredPaneFuncionario;
    private javax.swing.JLabel jNomeFunc;
    private javax.swing.JPanel jPanelBaseCadProd;
    private javax.swing.JPanel jPanelBaseEstoque;
    private javax.swing.JPanel jPanelBaseFuncionario;
    private javax.swing.JPanel jPanelCorpoBase;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JLabel jPermissao;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTxtCodBarras;
    private javax.swing.JTextField jTxtMatricula;
    private javax.swing.JTextField jTxtNmProd;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JTextField jTxtQteProd;
    private javax.swing.JTextField jTxtVlrCompra;
    private javax.swing.JTextField jTxtVlrVenda;
    // End of variables declaration//GEN-END:variables
}
