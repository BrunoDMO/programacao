package Desafio5.ex6;

public class Produto implements Vendavel {
    private String name;
    private double price;
    private int taxPercentage = 5;

    public Produto(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void precoFinal() {
        double tax = (double)(taxPercentage/100.0)*this.price;
        double precoFinal = this.price +tax;
        System.out.println("Preco final do Produto "+this.name+": R$"+precoFinal);
    }
}
