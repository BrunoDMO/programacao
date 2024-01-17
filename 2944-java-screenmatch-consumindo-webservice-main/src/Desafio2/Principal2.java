package Desafio2;

import java.util.Scanner;

public class Principal2 {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Fazer dvisão por dois numeros");
        System.out.println("Primeiro numero");
        int numero1 = leitura.nextInt();
        System.out.println("Segundo numero");
        int numero2 = leitura.nextInt();

        try {
            double resultado = numero1 / numero2;
            System.out.println("Resultado: " + resultado);
        }catch (ArithmeticException elemento) {
            System.out.println("Não pode ser feita a divisão por zero");
        }
    }
}
