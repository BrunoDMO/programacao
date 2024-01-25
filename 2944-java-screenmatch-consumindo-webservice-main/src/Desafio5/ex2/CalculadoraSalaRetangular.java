package Desafio5;

public class CalculadoraSalaRetangular implements CalculoGeometrico {
    @Override
    public void CalcularArea(double altura, double largura) {
        System.out.println("Área é de: " + (altura*largura) + " metros quadrados");
    }

    @Override
    public void CalcularPerimetro(double altura, double largura) {
        System.out.println("Perimetro é de: " + 2*(altura + largura));
    }
}
