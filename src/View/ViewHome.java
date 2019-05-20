package View;

import Modal.FuncionarioDao;
import Controller.*;
import Modal.CaixaDao;
import Modal.ProdutoDao;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ViewHome extends javax.swing.JFrame {
//recebe o funcionario q vem da tela de logim

    private FuncionarioDao funcDao;

    public ViewHome(FuncionarioDao fun) throws Exception {
        funcDao = new FuncionarioDao();
        funcDao = fun;//recebe o funcionario valido
        initComponents();
        Inicializacao();

    }

    //carrega as tabelas estoque e caixa
    public void LoadTable() {
        try {
            readTableEstoque();//le os item a serem add na tabela estoque
            readTableCaixa();//le os item a serem add na tabeela caixa
        } catch (Exception ex) {
            Logger.getLogger(ViewHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //metodo responsavel por pegar os item q vem do BD e colocar na tabela
    public void readTableEstoque() throws Exception {
        ProdutoDao prod = new ProdutoDao();
        DefaultTableModel modelo = (DefaultTableModel) jTableEstoque.getModel();
        modelo.setRowCount(0);

        for (ProdutoDao p : prod.Produtos()) {

            modelo.addRow(new Object[]{
                p.getCod_barra(),
                p.getNm_prod(),
                p.getVol_prod(),
                p.getQte_prod(),
                p.getVl_compra(),
                p.getVl_venda()
            });
        }
    }

    //metodo responsavel por pegar os item q vem do BD e colocar na tabela
    public void readTableCaixa() throws Exception {
        CaixaDao caixa = new CaixaDao();
        DefaultTableModel modelo = (DefaultTableModel) jTableCaixa.getModel();
        modelo.setRowCount(0);
        for (CaixaDao c : caixa.Vendas()) {
            modelo.addRow(new Object[]{
                c.getFuncioranrio().getMatricula(),
                c.getQte(),
                c.getData(),
                c.getValor()
            });
        }
    }

    //sobrecarga ViewHome
    public ViewHome() {
        initComponents();
        Inicializacao();
    }

    //set padrao de inicialização da aplicação
    private void Inicializacao() {
        jPanelCorpoBase.setVisible(true);
        PainelView(false, false, false);
        jNomeFunc.setText(funcDao.getNome());
        jMatricula.setText(String.valueOf(funcDao.getMatricula()));
        LoadTable();

    }

    //metodo responsavel pela troca de paineis
    private void PainelView(boolean btnFunc, boolean btnEstoq, boolean btnCad) {
        jPanelBaseEstoque.setVisible(btnEstoq);
        jPanelBaseCadProd.setVisible(btnCad);
        jPanelBaseFuncionario.setVisible(btnFunc);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMenu = new javax.swing.JPanel();
        jBtnCaixa = new javax.swing.JButton();
        jBtnEstoqueCaixa = new javax.swing.JButton();
        jBtnCadFuncionario = new javax.swing.JButton();
        jBtnEntradaProd = new javax.swing.JButton();
        jNomeFunc = new javax.swing.JLabel();
        jMatricula = new javax.swing.JLabel();
        jPanelCorpoBase = new javax.swing.JPanel();
        jLayeredPaneEstoque = new javax.swing.JLayeredPane();
        jPanelBaseEstoque = new javax.swing.JPanel();
        jTabbeGuia = new javax.swing.JTabbedPane();
        jEstoque = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEstoque = new javax.swing.JTable();
        jCaixa = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCaixa = new javax.swing.JTable();
        jLayeredPaneCadProd = new javax.swing.JLayeredPane();
        jPanelBaseCadProd = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jBtnCadProd = new javax.swing.JButton();
        jBtnAlterar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTxtVlrCompra = new javax.swing.JTextField();
        jTxtCodBarras = new javax.swing.JTextField();
        jTxtNmProd = new javax.swing.JTextField();
        jTxtVolumeProd = new javax.swing.JTextField();
        jTxtQteProd = new javax.swing.JTextField();
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

        jPanelMenu.setBackground(new java.awt.Color(0, 92, 153));

        jBtnCaixa.setBackground(new java.awt.Color(102, 204, 255));
        jBtnCaixa.setText("Caixa");
        jBtnCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCaixaActionPerformed(evt);
            }
        });

        jBtnEstoqueCaixa.setBackground(new java.awt.Color(102, 204, 255));
        jBtnEstoqueCaixa.setText("Estoque / Historico Caixa");
        jBtnEstoqueCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEstoqueCaixaActionPerformed(evt);
            }
        });

        jBtnCadFuncionario.setBackground(new java.awt.Color(102, 204, 255));
        jBtnCadFuncionario.setText("Cadastros funcionario");
        jBtnCadFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadFuncionarioActionPerformed(evt);
            }
        });

        jBtnEntradaProd.setBackground(new java.awt.Color(102, 204, 255));
        jBtnEntradaProd.setText("Entrada / cadastro de produto");
        jBtnEntradaProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEntradaProdActionPerformed(evt);
            }
        });

        jNomeFunc.setBackground(new java.awt.Color(255, 204, 153));
        jNomeFunc.setForeground(new java.awt.Color(255, 204, 153));
        jNomeFunc.setText("nome");
        jNomeFunc.setToolTipText("");

        jMatricula.setForeground(new java.awt.Color(255, 204, 153));
        jMatricula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jMatricula.setText("permissao");

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnEntradaProd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnCadFuncionario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnEstoqueCaixa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jBtnCaixa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelMenuLayout.createSequentialGroup()
                        .addComponent(jNomeFunc, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnEstoqueCaixa, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnCadFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnEntradaProd, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jNomeFunc)
                    .addComponent(jMatricula))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanelCorpoBase.setBackground(new java.awt.Color(77, 184, 255));

        jLayeredPaneEstoque.setBackground(new java.awt.Color(255, 255, 255));

        jPanelBaseEstoque.setBackground(new java.awt.Color(51, 173, 255));
        jPanelBaseEstoque.setLayout(new java.awt.BorderLayout());

        jEstoque.setBackground(new java.awt.Color(0, 122, 204));

        jTableEstoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cod_Bar", "Nome", "Volume", "Quantidade", "Valor Compra", "Valor Venda"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableEstoque);
        if (jTableEstoque.getColumnModel().getColumnCount() > 0) {
            jTableEstoque.getColumnModel().getColumn(0).setMinWidth(100);
        }

        javax.swing.GroupLayout jEstoqueLayout = new javax.swing.GroupLayout(jEstoque);
        jEstoque.setLayout(jEstoqueLayout);
        jEstoqueLayout.setHorizontalGroup(
            jEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 906, Short.MAX_VALUE)
            .addGroup(jEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE))
        );
        jEstoqueLayout.setVerticalGroup(
            jEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 511, Short.MAX_VALUE)
            .addGroup(jEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 511, Short.MAX_VALUE))
        );

        jTabbeGuia.addTab("Estoque", jEstoque);

        jCaixa.setBackground(new java.awt.Color(0, 122, 204));

        jTableCaixa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Funcionario", "Qte vendas", "Data", "Valor total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTableCaixa);
        if (jTableCaixa.getColumnModel().getColumnCount() > 0) {
            jTableCaixa.getColumnModel().getColumn(0).setHeaderValue("Funcionario");
            jTableCaixa.getColumnModel().getColumn(1).setHeaderValue("Qte vendas");
            jTableCaixa.getColumnModel().getColumn(2).setHeaderValue("Data");
            jTableCaixa.getColumnModel().getColumn(3).setHeaderValue("Valor total");
        }

        javax.swing.GroupLayout jCaixaLayout = new javax.swing.GroupLayout(jCaixa);
        jCaixa.setLayout(jCaixaLayout);
        jCaixaLayout.setHorizontalGroup(
            jCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 906, Short.MAX_VALUE)
        );
        jCaixaLayout.setVerticalGroup(
            jCaixaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
        );

        jTabbeGuia.addTab("Caixa", jCaixa);

        jPanelBaseEstoque.add(jTabbeGuia, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jLayeredPaneEstoqueLayout = new javax.swing.GroupLayout(jLayeredPaneEstoque);
        jLayeredPaneEstoque.setLayout(jLayeredPaneEstoqueLayout);
        jLayeredPaneEstoqueLayout.setHorizontalGroup(
            jLayeredPaneEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBaseEstoque, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jLayeredPaneEstoqueLayout.setVerticalGroup(
            jLayeredPaneEstoqueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelBaseEstoque, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
        );
        jLayeredPaneEstoque.setLayer(jPanelBaseEstoque, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLayeredPaneCadProd.setBackground(new java.awt.Color(255, 255, 255));

        jPanelBaseCadProd.setBackground(new java.awt.Color(51, 173, 255));

        jLabel1.setText("Codigo de Barras: ");

        jLabel2.setText("Nome Produto: ");

        jLabel3.setText("Valor Compra: ");

        jLabel4.setText("Quantidade: ");

        jLabel5.setText("Valor Venda: ");

        jLabel9.setText("Volume: ");

        jBtnCadProd.setText("Cadastrar");
        jBtnCadProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCadProdActionPerformed(evt);
            }
        });

        jBtnAlterar.setText("Alterar/Entrar Prod");
        jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAlterarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 173, 255));

        jTxtCodBarras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtCodBarrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTxtVlrCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
            .addComponent(jTxtVlrVenda)
            .addComponent(jTxtQteProd)
            .addComponent(jTxtVolumeProd)
            .addComponent(jTxtNmProd)
            .addComponent(jTxtCodBarras)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jTxtCodBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTxtNmProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTxtVolumeProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jTxtQteProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTxtVlrVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTxtVlrCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanelBaseCadProdLayout = new javax.swing.GroupLayout(jPanelBaseCadProd);
        jPanelBaseCadProd.setLayout(jPanelBaseCadProdLayout);
        jPanelBaseCadProdLayout.setHorizontalGroup(
            jPanelBaseCadProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBaseCadProdLayout.createSequentialGroup()
                .addGap(112, 112, 112)
                .addGroup(jPanelBaseCadProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBaseCadProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBaseCadProdLayout.createSequentialGroup()
                            .addComponent(jBtnCadProd)
                            .addGap(18, 18, 18))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBaseCadProdLayout.createSequentialGroup()
                            .addGroup(jPanelBaseCadProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(10, 10, 10)))
                    .addGroup(jPanelBaseCadProdLayout.createSequentialGroup()
                        .addGroup(jPanelBaseCadProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(10, 10, 10)))
                .addGroup(jPanelBaseCadProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBtnAlterar)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(526, Short.MAX_VALUE))
        );
        jPanelBaseCadProdLayout.setVerticalGroup(
            jPanelBaseCadProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBaseCadProdLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanelBaseCadProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelBaseCadProdLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelBaseCadProdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBtnCadProd)
                    .addComponent(jBtnAlterar))
                .addGap(262, 262, 262))
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

        jPanelBaseFuncionario.setBackground(new java.awt.Color(51, 173, 255));

        jLabel6.setText("nome: ");

        jTxtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtNomeActionPerformed(evt);
            }
        });

        jLabel7.setText("senha: ");

        jLabel8.setText("Matriula: ");

        jCheckBox1.setText("Permissão de cancelamento de compras.");

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
                .addContainerGap(562, Short.MAX_VALUE))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPaneFuncionarioLayout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addComponent(jPanelBaseFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(0, 0, 0)
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

    private void jBtnCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCaixaActionPerformed
        // Chama a tela ViewCaixa e passa o funcionario
        ViewCaixa caixa = new ViewCaixa(funcDao);
        this.dispose();
        caixa.setVisible(true);

    }//GEN-LAST:event_jBtnCaixaActionPerformed

    private void jBtnEstoqueCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEstoqueCaixaActionPerformed
        // checa a permissao do usuario e abre a tela de estoque
        if (funcDao.isPermissao()) {
            PainelView(false, true, false);

        } else {
            JOptionPane.showMessageDialog(null, "Usuario sem permissao");
        }
    }//GEN-LAST:event_jBtnEstoqueCaixaActionPerformed

    private void jBtnEntradaProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEntradaProdActionPerformed
        // checa a permissao do usuario e abre a tela de
        if (funcDao.isPermissao()) {
            PainelView(false, false, true);
        } else {
            JOptionPane.showMessageDialog(null, "Usuario sem permissao");
        }
    }//GEN-LAST:event_jBtnEntradaProdActionPerformed

    private void jTxtCodBarrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtCodBarrasActionPerformed
        try {
            //se houver produto cadastrado ele tras permitindo somente a atualização e alteraçõa do mesmo               

            String prod[] = new String[6];
            prod = Produto.buscaProd(jTxtCodBarras.getText());
            if (prod[1] != null) {
                jTxtNmProd.setText(prod[1]);
                jTxtVolumeProd.setText(prod[2]);
                jTxtQteProd.setText(prod[3]);
                jTxtVlrCompra.setText(prod[4]);
                jTxtVlrVenda.setText(prod[5]);
                jBtnCadProd.setVisible(false);
            } else {
                jTxtNmProd.setText(null);
                jTxtVolumeProd.setText(null);
                jTxtQteProd.setText(null);
                jTxtVlrCompra.setText(null);
                jTxtVlrVenda.setText(null);
                jBtnCadProd.setVisible(true);
            }

        } catch (Exception ex) {
            Logger.getLogger(ViewHome.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_jTxtCodBarrasActionPerformed

    private void jBtnCadFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadFuncionarioActionPerformed
        // abre o painel de cadFuncionario
        if (funcDao.isPermissao()) {
            PainelView(true, false, false);
        } else {
            JOptionPane.showMessageDialog(null, "usuario sem permissao");
        }
    }//GEN-LAST:event_jBtnCadFuncionarioActionPerformed

    private void jBtnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadastrarActionPerformed
        //insere os dados do novo "funcionario" no banco de dados
        try {
            Funcionario.FuncCadastrar(jTxtNome.getText(), jPassword.getText(), Integer.parseInt(jTxtMatricula.getText()), jCheckBox1.getHideActionText());
            JOptionPane.showMessageDialog(null, "Cadastro realizada com sucesso");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        jTxtNome.setText(null);
        jTxtMatricula.setText(null);
        jPassword.setText(null);
        jCheckBox1.setDropTarget(getDropTarget());
        jMatricula.setText(String.valueOf(funcDao.isPermissao()));


    }//GEN-LAST:event_jBtnCadastrarActionPerformed

    private void jTxtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtNomeActionPerformed
        try {
            //se houver nome cadastrado no banco ele tras a matricola permitindo a alteração do cadastro
            jTxtMatricula.setText(funcDao.Busca(jTxtNome.getText()));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jTxtNomeActionPerformed

    private void jBtnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDeletarActionPerformed
        //deleta funcionario no BD
        try {
            Funcionario.FuncDeletar(jTxtNome.getText(), jPassword.getText(), Integer.parseInt(jTxtMatricula.getText()), jCheckBox1.getHideActionText());
            JOptionPane.showMessageDialog(null, "Cadastro Deletado com sucesso");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        jTxtNome.setText(null);
        jTxtMatricula.setText(null);
        jPassword.setText(null);
        jCheckBox1.setDisabledIcon(null);

    }//GEN-LAST:event_jBtnDeletarActionPerformed

    private void jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAlterarActionPerformed
        try {
            // Atualiza / faz entrada de produtos no estoque
            int qte = Integer.parseInt(jTxtQteProd.getText());
            double vl_venda = Double.valueOf(jTxtVlrVenda.getText());
            double vl_comp = Double.valueOf(jTxtVlrCompra.getText());

            Produto.ProdAtualizar(jTxtCodBarras.getText(), jTxtNmProd.getText(), jTxtVolumeProd.getText(), qte, vl_comp, vl_venda);
            JOptionPane.showMessageDialog(null, "Cadastro Atualizado");
            LoadTable();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jBtnAlterarActionPerformed

    private void jBtnCadProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCadProdActionPerformed
        //checa se o produto ja foi cadastrado e atualiza
        try {
            String prod[] = new String[6];
            prod = Produto.buscaProd(jTxtCodBarras.getText());
            if (prod[1] == null) {
                int qte = Integer.parseInt(jTxtQteProd.getText());
                double vl_venda = Double.valueOf(jTxtVlrVenda.getText());
                double vl_comp = Double.valueOf(jTxtVlrCompra.getText());

                Produto.Prodcadastrar(jTxtCodBarras.getText(), jTxtNmProd.getText(), jTxtVolumeProd.getText(), qte, vl_comp, vl_venda);
                JOptionPane.showMessageDialog(null, "Cadastro Atualizado");
                LoadTable();
            } else {
                JOptionPane.showMessageDialog(null, "produto ja cadastrado");
                jTxtCodBarrasActionPerformed(evt);
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jBtnCadProdActionPerformed

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
            java.util.logging.Logger.getLogger(ViewHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new ViewHome().setVisible(true);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAlterar;
    private javax.swing.JButton jBtnCadFuncionario;
    private javax.swing.JButton jBtnCadProd;
    private javax.swing.JButton jBtnCadastrar;
    private javax.swing.JButton jBtnCaixa;
    private javax.swing.JButton jBtnDeletar;
    private javax.swing.JButton jBtnEntradaProd;
    private javax.swing.JButton jBtnEstoqueCaixa;
    private javax.swing.JPanel jCaixa;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JPanel jEstoque;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPaneCadProd;
    private javax.swing.JLayeredPane jLayeredPaneEstoque;
    private javax.swing.JLayeredPane jLayeredPaneFuncionario;
    private javax.swing.JLabel jMatricula;
    private javax.swing.JLabel jNomeFunc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBaseCadProd;
    private javax.swing.JPanel jPanelBaseEstoque;
    private javax.swing.JPanel jPanelBaseFuncionario;
    private javax.swing.JPanel jPanelCorpoBase;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbeGuia;
    private javax.swing.JTable jTableCaixa;
    private javax.swing.JTable jTableEstoque;
    private javax.swing.JTextField jTxtCodBarras;
    private javax.swing.JTextField jTxtMatricula;
    private javax.swing.JTextField jTxtNmProd;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JTextField jTxtQteProd;
    private javax.swing.JTextField jTxtVlrCompra;
    private javax.swing.JTextField jTxtVlrVenda;
    private javax.swing.JTextField jTxtVolumeProd;
    // End of variables declaration//GEN-END:variables
}
