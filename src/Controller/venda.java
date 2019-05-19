package Controller;

import Modal.*;

public class venda {

    public static void Atualizar(String cod, int matricula, double valor) {
        VendaDao venda = new VendaDao();
        FuncionarioDao func = new FuncionarioDao();
        ProdutoDao prod = new ProdutoDao();

        prod.setCod_barra(cod);
        func.setMatricula(matricula);
        venda.Atualizar(prod, func, valor);
    }
    public static double BuscarTotalValor() {
        VendaDao venda = new VendaDao();
        return venda.BuscaTotalValor();
    }

    public static void ZerarBd() {
        VendaDao venda = new VendaDao();
        venda.Zerar();
    }

    public static int BuscaQte(String cod) {
        VendaDao venda = new VendaDao();
        return venda.BuscaQte(cod);
    }

    public static double BuscaultValor(String cod) {
        VendaDao venda = new VendaDao();

        return venda.BuscaUltValor(cod);
    }

    public static void Entrar(String cod, int matricula, double valor) {
        VendaDao venda = new VendaDao();
        FuncionarioDao func = new FuncionarioDao();
        ProdutoDao prod = new ProdutoDao();

        prod.setCod_barra(cod);
        func.setMatricula(matricula);
        venda.Entrar(prod, func, valor);
    }
}
