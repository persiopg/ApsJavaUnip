package Controller;

import Modal.*;
import java.sql.Array;
import java.util.ArrayList;

public class Produto {

    public static String[] buscaProd(String Cod) throws Exception {
        ProdutoDao prod = new ProdutoDao().busca(Cod);

        String produto[] = new String[6];

        produto[0] = prod.getCod_barra();
        produto[1] = prod.getNm_prod();
        produto[2] = prod.getVol_prod();
        produto[3] = String.valueOf(prod.getQte_prod());
        produto[4] = String.valueOf(prod.getVl_compra());
        produto[5] = String.valueOf(prod.getVl_venda());

        return produto;
    }

    public static void ProdAtualizar(String cod, String nome, String vol, int qte, double vl_comp, double vl_venda) throws Exception {
        ProdutoDao prod = new ProdutoDao();

        prod.setCod_barra(cod);
        prod.setNm_prod(nome);
        prod.setVol_prod(vol);
        prod.setQte_prod(qte);
        prod.setVl_compra(vl_comp);
        prod.setVl_venda(vl_venda);

        prod.Atualizar(prod);

    }

    public static void ProdAtualizarQte(String cod, int qte) throws Exception {
        ProdutoDao prod = new ProdutoDao();
        prod.AtualizarQte(qte, cod);
    }

    public static void Prodcadastrar(String cod, String nome, String vol, int qte, double vl_comp, double vl_venda) throws Exception {
        ProdutoDao prod = new ProdutoDao();

        prod.setCod_barra(cod);
        prod.setNm_prod(nome);
        prod.setVol_prod(vol);
        prod.setQte_prod(qte);
        prod.setVl_compra(vl_comp);
        prod.setVl_venda(vl_venda);

        prod.cadastrar(prod);
    }

}
