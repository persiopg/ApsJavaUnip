package Modal;

public class Stock {
    
    private final Produto product;
    private double value;
    private int amount;
    

    public Stock(Produto product) {
        this.product = product;
    }

    
    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Produto getProduct() {
        return product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    
}
    