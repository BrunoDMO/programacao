package Desafio5.ex5;

public class Livro implements Calculavel{
    private String nome;
    private double preco;
    private int paginas;

    public Livro(String nome, double preco, int paginas) {
        this.nome = nome;
        this.preco = preco;
        this.paginas = paginas;
    }

    private double porcento = 10;//%desconto

    @Override
    public double calcularPrecoFinal() {
        double desconto = this.preco * (porcento/100);
        double precoFinal = this.preco - desconto;
        System.out.println("Nome do livro: "+this.nome);
        System.out.println("Preço do livro: R$"+this.preco);
        System.out.println("Desconto: R$"+desconto);
        System.out.println("Preco Total: R$"+precoFinal);
        return precoFinal;
    }
}
