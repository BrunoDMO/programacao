public class Estudos {
    public static void main(String[] args) {
        // escrevendo main, ele autocompleta com public static void main(string[] args){}
        // system.out.printf atalho "souf"
        float temperaturaC = 50;
        float temperaturaF = (float) ((temperaturaC * 1.8) + 32);
        System.out.println("Celsius: " + temperaturaC);
        System.out.println("Fahrenheit: " + temperaturaF);

        String mensagem = String.format("A temperatura de %.2f Celsius é equivalente a %.2f Fahrenheit", temperaturaC, temperaturaF);
        System.out.println(mensagem);

        int media1 = 6;
        int media2 = 8;
        int resultado = (media1 + media2) / 2;
        System.out.println("media das notas é: " + resultado);

        int valor1 = 1;
        double valor2 = valor1;
        System.out.println(valor2);

        char letra = 'A';
        String palavra = "mendoim";
        System.out.println(letra + palavra);

        double precoProduto = 56.5;
        double quantidade = 4;
        double total = precoProduto * quantidade;
        String mensagemTotal = String.format("""
                preço por produto: R$%.2f
                quantidade de produto %.0f 
                preço total: R$%.2f
                """, precoProduto, quantidade, total);
        System.out.println(mensagemTotal);

        double reais = 5;
        double valoremDolares = reais * 4.94;
        System.out.println(String.format("$%.2f",valoremDolares));

        double precoOriginal = 10;
        double percentualDesconto = 10;//desconto 10%
        double valorDesconto = (percentualDesconto/100)*precoOriginal;
        double novoPreco = precoOriginal - valorDesconto;
        System.out.println("Novo preço é de: R$" + novoPreco);


    }
}
