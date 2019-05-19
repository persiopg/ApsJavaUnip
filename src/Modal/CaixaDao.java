package Modal;

import Controller.ConectionFactory;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CaixaDao {

    private FuncionarioDao funcioranrio;
    private int qte;
    private String data;
    private double valor;
    private final ConectionFactory con = new ConectionFactory();
    private PreparedStatement pst;

    public CaixaDao() {
    }

    public CaixaDao(FuncionarioDao funcioranrio, int qte, String data, double valor) {
        this.funcioranrio = funcioranrio;
        this.qte = qte;
        this.data = data;
        this.valor = valor;
    }

    public void Insereir(CaixaDao caixa) {
        try {
            String use = "INSERT INTO tb_caixa (id_func,qte_vendas,data_vendas,valor_total) VALUES(?,?,?,?);";
            pst = con.Conection().prepareStatement(use);
            pst.setInt(1, caixa.funcioranrio.getMatricula());
            pst.setInt(2, caixa.getQte());
            pst.setString(3, caixa.getData());
            pst.setDouble(4, caixa.getValor());
            pst.execute();
            pst.close();
            con.Close();
        } catch (Exception ex) {
            Logger.getLogger(VendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public ArrayList<CaixaDao> Vendas() throws Exception {
        ArrayList<CaixaDao> vendas = new ArrayList<>();

        ResultSet resultUser = Buscartodos();

        while (resultUser.next()) {
            CaixaDao caixa = new CaixaDao();
            FuncionarioDao func = new FuncionarioDao();
            func.setMatricula(resultUser.getInt("id_func"));
            caixa.setFuncioranrio(func);
            caixa.setQte(resultUser.getInt("qte_vendas"));
            caixa.setData(resultUser.getString("data_vendas"));
            caixa.setValor(resultUser.getDouble("valor_Total"));

            vendas.add(caixa);

            caixa = null;
        }

        return vendas;
    }

    private ResultSet Buscartodos() throws Exception {

        String use = "SELECT * FROM tb_caixa;";
        pst = con.Conection().prepareStatement(use);
        ResultSet resultUser = pst.executeQuery();

        return resultUser;
    }

    public int getQte() {
        return qte;
    }

    public void setQte(int qte) {
        this.qte = qte;
    }

    public FuncionarioDao getFuncioranrio() {
        return funcioranrio;

    }

    public void setFuncioranrio(FuncionarioDao funcioranrio) {
        this.funcioranrio = funcioranrio;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
