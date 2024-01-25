package Desafio5.ex5;

public class ProdutoFisico implements Calculavel{
    private String nome;
    private double preco;

    public ProdutoFisico(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    private double porcento = 50;//%taxa


    @Override
    public double calcularPrecoFinal() {
        double taxa = this.preco * (porcento/100);
        double precoFinal = this.preco + taxa;
        System.out.println("Nome do produto: "+this.nome);
        System.out.println("Preço do produto: R$"+this.preco);
        System.out.println("Taxa: R$"+taxa);
        System.out.println("Preco Final: R$"+precoFinal);
        return precoFinal;
    }
}
