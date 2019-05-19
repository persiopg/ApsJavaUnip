
package Controller;

import Modal.CaixaDao;
import Modal.FuncionarioDao;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class caixa {
    
    public static void inserir(int cod, int qte, String data, double valor){
        
        FuncionarioDao func = new FuncionarioDao();
        func.setMatricula(cod);        
        CaixaDao caixa = new CaixaDao(func,qte,data,valor);
        caixa.Insereir(caixa);
    }
    public static ArrayList<String[]>ListarVendas(){
        try {
            CaixaDao caixa = new CaixaDao();
            ArrayList<CaixaDao> caix = caixa.Vendas();
            ArrayList<String[]> listVendas = new ArrayList<>();
            for (int i = 0; i < caix.size(); i++) {
                String cx[] = new String[4];
                cx[0] = String.valueOf(caix.get(i).getFuncioranrio().getMatricula());
                cx[1] = String.valueOf(caix.get(i).getQte());
                cx[2] = caix.get(i).getData();
                cx[3] = String.valueOf(caix.get(i).getValor());
                listVendas.add(cx);
            }
            return listVendas;
        } catch (Exception ex) {
            Logger.getLogger(caixa.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
