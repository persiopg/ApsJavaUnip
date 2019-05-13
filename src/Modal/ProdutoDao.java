package Modal;

import Controller.*;
import java.awt.List;
import java.sql.*;
import java.util.ArrayList;



public class ProdutoDao {
    private String cod_barra;
    private String nm_prod;
    private String vol_prod;
    private int qte_prod;
    private double vl_compra;
    private double vl_venda;
    private ProdutoDao produto;
    private final ConectionFactory con = new ConectionFactory();
    private PreparedStatement pst;
    
    
    public ProdutoDao busca(String cod) throws Exception{              
        String use = "SELECT * FROM tb_produto WHERE cod_barra LIKE ?;";
        pst = con.Conection().prepareStatement(use);
        pst.setString(1, cod);
        ResultSet resultUser = pst.executeQuery();
        
        while (resultUser.next()) {        
            cod_barra = resultUser.getString("cod_barra");
            nm_prod = resultUser.getString("nm_prod");
            vol_prod = resultUser.getString("vl_compra");
            qte_prod = resultUser.getInt("qte_prod");
            vl_compra = resultUser.getDouble("vl_compra");
            vl_venda = resultUser.getDouble("vl_venda");
        }
         
        pst.close();
        con.Close();
        produto = new ProdutoDao();
        
        produto.setCod_barra(cod_barra);        
        produto.setNm_prod(nm_prod);
        produto.setVol_prod(vol_prod);
        produto.setQte_prod(qte_prod);
        produto.setVl_compra(vl_compra);
        produto.setVl_venda(vl_venda);
        
        return produto;
        
    }
    public void cadastrar (ProdutoDao prod) throws Exception{
        String use = "INSERT INTO tb_produto (cod_barra, nm_prod, vol_prod, qte_prod, vl_compra, vl_venda) VALUES(?,?,?,?,?,?);";
        pst = con.Conection().prepareStatement(use);        
        pst.setString(1, prod.getCod_barra());
        pst.setString(2, prod.getNm_prod());
        pst.setString(3,prod.getVol_prod());
        pst.setInt(4,prod.getQte_prod());
        pst.setDouble(5,prod.getVl_compra());
        pst.setDouble(6,prod.getVl_venda());               
        pst.execute();
        pst.close();
        con.Close();
    }
    public void Atualizar(ProdutoDao prod) throws Exception{
        String use = "UPDATE tb_produto SET cod_barra = ?, nm_prod = ?, vol_prod = ?, qte_prod = ?, vl_compra = ?, vl_venda = ? WHERE cod_barra = ?";
        pst = con.Conection().prepareStatement(use);        
        pst.setString(1, prod.getCod_barra());
        pst.setString(2, prod.getNm_prod());
        pst.setString(3,prod.getVol_prod());
        pst.setInt(4,prod.getQte_prod());
        pst.setDouble(5,prod.getVl_compra());
        pst.setDouble(6,prod.getVl_venda());       
        pst.setString(7, prod.getCod_barra());
        pst.execute();
        pst.close();
        con.Close();
    }

    public String getNm_prod() {
        return nm_prod;
    }
    
    
   // public 

    public String getCod_barra() {
        return cod_barra;
    }

    public void setCod_barra(String cod_barra) {
        this.cod_barra = cod_barra;
    }

    public void setNm_prod(String nm_prod) {
        this.nm_prod = nm_prod;
    }

    public String getVol_prod() {
        return vol_prod;
    }

    public void setVol_prod(String vol_prod) {
        this.vol_prod = vol_prod;
    }

    public int getQte_prod() {
        return qte_prod;
    }

    public void setQte_prod(int qte_prod) {
        this.qte_prod = qte_prod;
    }

    public double getVl_compra() {
        return vl_compra;
    }

    public void setVl_compra(double vl_compra) {
        this.vl_compra = vl_compra;
    }

    public double getVl_venda() {
        return vl_venda;
    }

    public void setVl_venda(double vl_venda) {
        this.vl_venda = vl_venda;
    }
    public String getProdutoString(String cod) throws Exception{
        String produtos;
        ProdutoDao prod = busca(cod);
        produtos = prod.toString();
        return produtos;
    }
    @Override
    public String toString() {
        return " nm_prod=" + nm_prod + "----------vol_prod=" + vol_prod + "\n vl_venda=" + vl_venda + '}';
    }
}
