package Modal;

import Controller.ConectionFactory;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendaDao {

    private FuncionarioDao funcionario;
    private ProdutoDao produto;
    private double valorTotal;
    private final ConectionFactory con = new ConectionFactory();
    private PreparedStatement pst;

    public void Atualizar(ProdutoDao prod, FuncionarioDao func, double valor) {
        try {
            String use = "UPDATE tb_venda SET id_func = ?, cod_prod = ?, valor_total = ? WHERE cod_prod = ?;";
            pst = con.Conection().prepareStatement(use);
            pst.setInt(1, func.getMatricula());
            pst.setString(2, prod.getCod_barra());
            pst.setDouble(3, valor);
            pst.setString(4, prod.getCod_barra());
            pst.execute();
            pst.close();
            con.Close();
        } catch (Exception ex) {
            Logger.getLogger(VendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Zerar() {
        try {
            String use = "DELETE FROM tb_venda;";
            pst = con.Conection().prepareStatement(use);
            pst.execute();
            pst.close();
            con.Close();
        } catch (Exception ex) {
            Logger.getLogger(VendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Entrar(ProdutoDao prod, FuncionarioDao func, double valor) {
        try {
            String use = "INSERT INTO tb_venda (id_func, cod_prod, valor_total) VALUES(?,?,?);";
            pst = con.Conection().prepareStatement(use);
            pst.setInt(1, func.getMatricula());
            pst.setString(2, prod.getCod_barra());
            pst.setDouble(3, valor);
            pst.execute();

            pst.close();
            con.Close();
        } catch (Exception ex) {
            Logger.getLogger(VendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public double BuscaUltValor(String cod) {
        try {
            String use = "SELECT * FROM tb_venda WHERE cod_prod LIKE ?;";
            pst = con.Conection().prepareStatement(use);
            pst.setString(1, cod);
            ResultSet resultUser = pst.executeQuery();
            funcionario = new FuncionarioDao();
            produto = new ProdutoDao();
            while (resultUser.next()) {
                produto.setVl_venda(resultUser.getInt("valor_total"));
            }

            pst.close();
            con.Close();
        } catch (Exception ex) {
            Logger.getLogger(VendaDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return produto.getVl_venda();
    }

    public double BuscaTotalValor() {
        try {
            String use = "SELECT * FROM tb_venda;";
            pst = con.Conection().prepareStatement(use);
            ResultSet resultUser = pst.executeQuery();
            double valorTemp = 0;
            while (resultUser.next()) {
                valorTemp += resultUser.getDouble("valor_total");
            }
            valorTotal = valorTemp;
            pst.close();
            con.Close();
        } catch (Exception ex) {
            Logger.getLogger(VendaDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return valorTotal;
    }

    public int BuscaQte(String cod) {
        try {

            String use = "select qte_prod from tb_produto p inner join tb_venda v on p.cod_barra = v.cod_prod WHERE cod_prod LIKE ?;";
            pst = con.Conection().prepareStatement(use);
            pst.setString(1, cod);
            ResultSet resultUser = pst.executeQuery();
            produto = new ProdutoDao();
            while (resultUser.next()) {
                produto.setQte_prod(resultUser.getInt("qte_prod"));
            }

            pst.close();
            con.Close();
        } catch (Exception ex) {
            Logger.getLogger(VendaDao.class.getName()).log(Level.SEVERE, null, ex);

        }
        return produto.getQte_prod();
    }
}
