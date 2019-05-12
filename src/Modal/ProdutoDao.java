package Modal;

import Controller.*;
import java.sql.*;



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
            produto.cod_barra = resultUser.getString("cod_barra");
            produto.nm_prod = resultUser.getString("nm_prod");
            produto.vol_prod = resultUser.getString("vl_compra");
            produto.qte_prod = resultUser.getInt("qte_prod");
            produto.vl_compra = resultUser.getDouble("vl_compra");
            produto.vl_venda = resultUser.getDouble("vl_venda");
        }
         
        pst.close();
        con.Close();
        
        return produto;
    }

    public String getCod_barra() {
        return cod_barra;
    }

    public void setCod_barra(String cod_barra) {
        this.cod_barra = cod_barra;
    }

    public String getNm_prod() {
        return nm_prod;
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
    
}
