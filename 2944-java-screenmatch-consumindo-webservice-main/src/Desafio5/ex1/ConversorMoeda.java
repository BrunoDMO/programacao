package Desafio5.ex1;

public class ConversorMoeda implements ConversaoFinanceira{
    private double real = 5.17;
    private double realConvertido;

    public double getRealConvertido() {
        return realConvertido;
    }

    @Override
    public void converterDolarParaReal(double valorDolar) {
        realConvertido = real * valorDolar;
    }
}
