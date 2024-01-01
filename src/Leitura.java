import java.util.Scanner;

public class Leitura {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        System.out.println("escreva");
        String texto = leitura.nextLine();
        System.out.println(texto);

        leitura.close();
    }
}
