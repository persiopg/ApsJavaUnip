/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Produto;
import Controller.caixa;
import Controller.venda;
import Modal.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class JCaixa extends javax.swing.JFrame {

    private FuncionarioDao fun;
    private int cont = 0;
    private int contExcluir = 0;
    private double valor;
    private double ultimoValor;
    private int ultimaQte;
    private String ultimacod;

    public JCaixa(FuncionarioDao fun) {
        initComponents();
        inicializacao();
        this.fun = fun;
    }

    public JCaixa() {
        initComponents();
        inicializacao();

    }

    private void inicializacao() {
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setUndecorated(true);
        jTxtCodBarra.requestFocus();
        jPanelFinalcompra.setVisible(false);
        jTxtSubTotal.setText("0");

    }

    public void readTable() {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

    }

    public void excluirUltimaLinha() {
        valor = venda.BuscaultValor(ultimacod) - ultimoValor;
        int tempqte = venda.BuscaQte(ultimacod) + ultimaQte;
        SubMatRemove(ultimoValor, Double.parseDouble(jTxtSubTotal.getText()));
        AtulizaBanco(ultimacod, fun.getMatricula(), valor, tempqte);
        ((DefaultTableModel) jTable1.getModel()).removeRow(jTable1.getRowCount() - 1);
    }

    public void readTable(String[] prods) {
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();

        String prod[] = new String[6];
        prod = prods;
        double valores = 0;
        valores = Double.parseDouble(prod[5]) * Integer.parseInt(jTxtQte.getText());
        if(Integer.parseInt(prods[3]) >0){
        modelo.addRow(new Object[]{
            prod[0],
            prod[1] + " " + prod[2],
            Integer.parseInt(jTxtQte.getText()),
            "R$ " + String.valueOf(valores)
        });
        SubMatAdd(valores, Double.parseDouble(jTxtSubTotal.getText()));
        }
        else{
            JOptionPane.showMessageDialog(this, "NAO A QUANTIDADE EM ESTOQUE");
        }
    }

    private void SubMatAdd(double valor, double sub) {
        double result = 0;
        result = valor + sub;
        System.out.println("valor pra add:" + result);
        jTxtSubTotal.setText(String.valueOf(result));
    }

    private void SubMatRemove(double valor, double sub) {
        double result = 0;
        result = sub - valor;
        if (result <= 0) {
            result = 0;
        }
        jTxtSubTotal.setText(String.valueOf(result));
    }

    private void AtulizaBanco(String cod, int matricula, double valor, int qte) {
        try {
            venda.Atualizar(cod, matricula, valor);
            Produto.ProdAtualizarQte(cod, qte);
        } catch (Exception ex) {
            Logger.getLogger(JCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String[] Add(String cod) {
        try {
            // TODO add your handling code here:
            ultimaQte = 0;
            ultimoValor = 0;
            String prod[] = new String[6];

            prod = Produto.buscaProd(cod);

            if (venda.BuscaQte(cod) == Integer.parseInt(prod[3])) {
                valor = venda.BuscaultValor(cod) + (Double.parseDouble(prod[5]) * Integer.parseInt(jTxtQte.getText()));
                int TempQte = Integer.parseInt(prod[3]) - Integer.parseInt(jTxtQte.getText());
                AtulizaBanco(cod, fun.getMatricula(), valor, TempQte);
                ultimoValor = (Double.parseDouble(prod[5]) * Integer.parseInt(jTxtQte.getText()));
                ultimaQte = Integer.parseInt(jTxtQte.getText());
                ultimacod = cod;
                return prod;
            } else if (Integer.parseInt(jTxtQte.getText()) <= Integer.parseInt(prod[3])) {
                valor = (Double.parseDouble(prod[5]) * Integer.parseInt(jTxtQte.getText()));
                venda.Entrar(cod, fun.getMatricula(), valor);
                int TempQte = Integer.parseInt(prod[3]) - Integer.parseInt(jTxtQte.getText());
                Produto.ProdAtualizarQte(cod, TempQte);
                ultimoValor = (Double.parseDouble(prod[5]) * Integer.parseInt(jTxtQte.getText()));
                ultimaQte = Integer.parseInt(jTxtQte.getText());
                ultimacod = cod;
                return prod;
            }

        } catch (Exception ex) {
            Logger.getLogger(JCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private void Zerar() {
        jPanelCaixa.setVisible(true);
        jPanelFinalcompra.setVisible(false);
        jTxtSubTotal.setText("0");
        jValorclient.setText("");
        jTroco.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLayeredPaneCaixa = new javax.swing.JLayeredPane();
        jPanelCaixa = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTxtCodBarra = new javax.swing.JTextField();
        jTxtSubTotal = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jTxtQte = new javax.swing.JTextField();
        jLayeredPaneFinalCompra = new javax.swing.JLayeredPane();
        jPanelFinalcompra = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxPagamento = new javax.swing.JComboBox();
        jValorFinal = new javax.swing.JLabel();
        jValorclient = new javax.swing.JTextField();
        jTroco = new javax.swing.JTextField();
        jBtnFinalizar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemSair = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemAddQte = new javax.swing.JMenuItem();
        jMenuItemExcluir = new javax.swing.JMenuItem();
        jMenuItemCancelarC = new javax.swing.JMenuItem();
        jMenuItemFinalizar = new javax.swing.JMenuItem();

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Caixa Aberto");

        jPanelCaixa.setBackground(new java.awt.Color(0, 153, 255));

        jButton1.setText("Finalizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 179));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Sair - ESC");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Adicionar Qte - F3");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Excluir Ultimo item - F4");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Cancelar Compra - F5");

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Finalizar Compra - F9");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addContainerGap(270, Short.MAX_VALUE))
        );

        jTxtCodBarra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtCodBarraActionPerformed(evt);
            }
        });

        jTxtSubTotal.setEditable(false);
        jTxtSubTotal.setText("0");
        jTxtSubTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtSubTotalActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Codigo de barras: ");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Sub Total:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo de Barras", "Descrissao", "Quantidade", "Valor"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(150);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(250);
            jTable1.getColumnModel().getColumn(2).setMinWidth(50);
            jTable1.getColumnModel().getColumn(2).setMaxWidth(100);
            jTable1.getColumnModel().getColumn(3).setMinWidth(150);
            jTable1.getColumnModel().getColumn(3).setMaxWidth(250);
        }

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Qte.:");

        jTxtQte.setEditable(false);
        jTxtQte.setText("1");
        jTxtQte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtQteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelCaixaLayout = new javax.swing.GroupLayout(jPanelCaixa);
        jPanelCaixa.setLayout(jPanelCaixaLayout);
        jPanelCaixaLayout.setHorizontalGroup(
            jPanelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCaixaLayout.createSequentialGroup()
                .addGroup(jPanelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelCaixaLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 857, Short.MAX_VALUE))
                    .addGroup(jPanelCaixaLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCaixaLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCaixaLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTxtSubTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                            .addComponent(jTxtCodBarra, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(28, 28, 28)
                .addGroup(jPanelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCaixaLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap(124, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCaixaLayout.createSequentialGroup()
                        .addGroup(jPanelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelCaixaLayout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTxtQte))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(20, 20, 20))))
        );
        jPanelCaixaLayout.setVerticalGroup(
            jPanelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCaixaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCaixaLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTxtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)))
                    .addGroup(jPanelCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTxtCodBarra, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTxtQte, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(236, 236, 236))
        );

        javax.swing.GroupLayout jLayeredPaneCaixaLayout = new javax.swing.GroupLayout(jLayeredPaneCaixa);
        jLayeredPaneCaixa.setLayout(jLayeredPaneCaixaLayout);
        jLayeredPaneCaixaLayout.setHorizontalGroup(
            jLayeredPaneCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jLayeredPaneCaixaLayout.setVerticalGroup(
            jLayeredPaneCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelCaixa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jLayeredPaneCaixa.setLayer(jPanelCaixa, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jPanelFinalcompra.setBackground(new java.awt.Color(128, 204, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Selecione o metodo de pagamento");

        jComboBoxPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Selecione Metodo de Pagamento>", "Dinheiro", "Credito", "Debito" }));
        jComboBoxPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxPagamentoActionPerformed(evt);
            }
        });

        jValorFinal.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jValorFinal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jValorFinal.setText("R$ 00.00");

        jValorclient.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jValorclient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jValorclientActionPerformed(evt);
            }
        });

        jTroco.setEditable(false);
        jTroco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTroco.setDoubleBuffered(true);

        jBtnFinalizar.setText("Finalizar Compra");
        jBtnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFinalcompraLayout = new javax.swing.GroupLayout(jPanelFinalcompra);
        jPanelFinalcompra.setLayout(jPanelFinalcompraLayout);
        jPanelFinalcompraLayout.setHorizontalGroup(
            jPanelFinalcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFinalcompraLayout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addGroup(jPanelFinalcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jValorFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxPagamento, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jValorclient)
                    .addComponent(jTroco)
                    .addComponent(jBtnFinalizar))
                .addGap(347, 347, 347))
        );
        jPanelFinalcompraLayout.setVerticalGroup(
            jPanelFinalcompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFinalcompraLayout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jValorFinal, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxPagamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jValorclient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTroco)
                .addGap(41, 41, 41)
                .addComponent(jBtnFinalizar)
                .addGap(470, 470, 470))
        );

        javax.swing.GroupLayout jLayeredPaneFinalCompraLayout = new javax.swing.GroupLayout(jLayeredPaneFinalCompra);
        jLayeredPaneFinalCompra.setLayout(jLayeredPaneFinalCompraLayout);
        jLayeredPaneFinalCompraLayout.setHorizontalGroup(
            jLayeredPaneFinalCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFinalcompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jLayeredPaneFinalCompraLayout.setVerticalGroup(
            jLayeredPaneFinalCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFinalcompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jLayeredPaneFinalCompra.setLayer(jPanelFinalcompra, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 204));

        jMenu2.setText("Arquivos");

        jMenuItemSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        jMenuItemSair.setText("Sair");
        jMenuItemSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSairActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemSair);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Comandos");

        jMenuItemAddQte.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItemAddQte.setText("Adicionar Qte");
        jMenuItemAddQte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAddQteActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemAddQte);

        jMenuItemExcluir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItemExcluir.setText("Excluir");
        jMenuItemExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExcluirActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemExcluir);

        jMenuItemCancelarC.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItemCancelarC.setText("Cancelar Compra");
        jMenuItemCancelarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCancelarCActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemCancelarC);

        jMenuItemFinalizar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F9, 0));
        jMenuItemFinalizar.setText("Finalizar compra");
        jMenuItemFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFinalizarActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemFinalizar);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPaneCaixa)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLayeredPaneFinalCompra))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPaneCaixa)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLayeredPaneFinalCompra))
        );

        setSize(new java.awt.Dimension(1116, 859));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (jTxtSubTotal.getText() == "" || jTxtSubTotal.getText() == "0" || jTxtSubTotal.getText() == " " || jTxtSubTotal.getText() == null) {
            JOptionPane.showMessageDialog(this, "ERRO AO FINALIZAR COMPRA: " + "\nNAO A ITEM ADD AO CAIXA ");
        } else {

            jValorFinal.setVisible(true);
            jTroco.setVisible(true);
            jPanelCaixa.setVisible(false);
            jPanelFinalcompra.setVisible(true);
            jBtnFinalizar.setVisible(true);
            jValorFinal.setText(jTxtSubTotal.getText());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTxtSubTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtSubTotalActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jTxtSubTotalActionPerformed

    private void jTxtCodBarraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCodBarraActionPerformed

        readTable(Add(jTxtCodBarra.getText()));
        jTxtCodBarra.setText("");
    }//GEN-LAST:event_jTxtCodBarraActionPerformed

    private void jMenuItemAddQteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAddQteActionPerformed
        // TODO add your handling code here:
        if (jTxtQte.isCursorSet()) {
            jTxtCodBarra.grabFocus();
            jTxtQte.setEditable(false);
        } else {
            jTxtQte.setEditable(true);
            jTxtQte.grabFocus();
        }
    }//GEN-LAST:event_jMenuItemAddQteActionPerformed

    private void jTxtQteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtQteActionPerformed
        // TODO add your handling code here:
        jTxtCodBarraActionPerformed(evt);
        jTxtQte.setText("1");
        jTxtQte.setEditable(false);

    }//GEN-LAST:event_jTxtQteActionPerformed

    private void jMenuItemFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFinalizarActionPerformed
        // TODO add your handling code here:
        jButton1ActionPerformed(evt);
    }//GEN-LAST:event_jMenuItemFinalizarActionPerformed

    private void jComboBoxPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxPagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxPagamentoActionPerformed

    private void jValorclientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jValorclientActionPerformed
        // TODO add your handling code here:
        double troco = 0;
        troco = Double.parseDouble(jValorclient.getText()) - Double.valueOf(jValorFinal.getText());
        jTroco.setText(String.valueOf(troco));
    }//GEN-LAST:event_jValorclientActionPerformed

    private void jBtnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFinalizarActionPerformed
        // TODO add your handling code here:

        if (jComboBoxPagamento.getSelectedItem().equals("<Selecione Metodo de Pagamento>")) {
            JOptionPane.showMessageDialog(this, "Selecione um Metodo de Pagamento");
        } else {
            if (jValorclient.getText() == "" || jValorclient.getText() == "0" || jValorclient.getText() == " " || jValorclient.getText() == null) {
                JOptionPane.showMessageDialog(this, "Infome o valor pago");
            } else {
                cont++;

                JOptionPane.showMessageDialog(this, "compra Finalizada");
                Zerar();
                readTable();
            }
        }
    }//GEN-LAST:event_jBtnFinalizarActionPerformed

    private void jMenuItemSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSairActionPerformed
        try {
            // TODO add your handling code here:
            LocalDate data = LocalDate.now();
            String DATA = String.valueOf(data);
            String ano = DATA.substring(0, 4);
            String mes = DATA.substring(5, 7);
            String dia = DATA.substring(8);
            String dmaData = dia + "/" + mes + "/" + ano;

            caixa.inserir(fun.getMatricula(), cont, dmaData, venda.BuscarTotalValor());
            System.out.println(fun.getMatricula() + " - " + cont + " - " + dmaData + " - " + venda.BuscarTotalValor());
            View view = new View(fun);
            view.setVisible(true);
            this.dispose();
            venda.ZerarBd();
        } catch (Exception ex) {
            Logger.getLogger(JCaixa.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItemSairActionPerformed

    private void jMenuItemExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExcluirActionPerformed
        // TODO add your handling code here:
        if (contExcluir == 0) {
            excluirUltimaLinha();
            contExcluir++;
        } else {
            JOptionPane.showMessageDialog(this, "Ultimo item ja excluido");
        }

    }//GEN-LAST:event_jMenuItemExcluirActionPerformed

    private void jMenuItemCancelarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCancelarCActionPerformed
        // TODO add your handling code here:
        readTable();
        Zerar();
    }//GEN-LAST:event_jMenuItemCancelarCActionPerformed

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
            java.util.logging.Logger.getLogger(JCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JCaixa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JCaixa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnFinalizar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBoxPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPaneCaixa;
    private javax.swing.JLayeredPane jLayeredPaneFinalCompra;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemAddQte;
    private javax.swing.JMenuItem jMenuItemCancelarC;
    private javax.swing.JMenuItem jMenuItemExcluir;
    private javax.swing.JMenuItem jMenuItemFinalizar;
    private javax.swing.JMenuItem jMenuItemSair;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelCaixa;
    private javax.swing.JPanel jPanelFinalcompra;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTroco;
    private javax.swing.JTextField jTxtCodBarra;
    private javax.swing.JTextField jTxtQte;
    private javax.swing.JTextField jTxtSubTotal;
    private javax.swing.JLabel jValorFinal;
    private javax.swing.JTextField jValorclient;
    // End of variables declaration//GEN-END:variables
}
