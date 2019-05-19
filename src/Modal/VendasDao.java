
package Modal;

import java.time.LocalDate;

public class VendasDao {
    private FuncionarioDao funcioranrio;
    private LocalDate data;
    private int vendas;
    private double valor;   

    public VendasDao() {
    }

    public VendasDao(FuncionarioDao funcioranrio, LocalDate data, int vendas, double valor) {
        this.funcioranrio = funcioranrio;
        this.data = data;
        this.vendas = vendas;
        this.valor = valor;
    }
    

    public FuncionarioDao getFuncioranrio() {
        return funcioranrio;
    }

    public void setFuncioranrio(FuncionarioDao funcioranrio) {
        this.funcioranrio = funcioranrio;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getVendas() {
        return vendas;
    }

    public void setVendas(int vendas) {
        this.vendas = vendas;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
