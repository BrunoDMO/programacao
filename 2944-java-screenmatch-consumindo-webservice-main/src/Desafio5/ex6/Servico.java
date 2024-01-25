package Desafio5.ex6;

public class Servico implements Vendavel{

    private String name;
    private double price;
    private int taxPercentage = 10;

    public Servico(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void precoFinal() {
        double tax =(taxPercentage/100.0)*this.price;
        double precoFinal = this.price + tax;
        System.out.println("Preco final do Servico de "+this.name+": R$"+precoFinal);
    }
}
