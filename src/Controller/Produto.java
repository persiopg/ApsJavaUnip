package Controller;

import Modal.*;

public class Produto {
    public static String[] buscaProd(String Cod) throws Exception{
        ProdutoDao prod = new ProdutoDao();
        ProdutoDao prod2 = prod.busca(Cod);
        
        String produto[] = new String[6];
        produto[0] = prod2.getCod_barra();
        produto[1] = prod2.getNm_prod();
        produto[2] = prod2.getVol_prod();
        produto[3] = String.valueOf(prod2.getQte_prod());
        produto[4] = String.valueOf(prod2.getVl_compra());
        produto[5] = String.valueOf(prod2.getVl_venda());

        
        return produto;
    }
}
