import java.util.Random;
import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {
        System.out.println("Iniciando Jogo");
        int numeroSecreto = new Random().nextInt(10);
        System.out.println("numero secreto é: " + numeroSecreto);
        int i = 1;
        while (i <= 5) {
            Scanner leitura = new Scanner(System.in);
            System.out.println("adivinhe o numero");
            int numero = leitura.nextInt();
            System.out.println("você escreveu " + numero);

            if(numero < numeroSecreto) {
                System.out.println("numero secreto é maior");
            } else if (numero > numeroSecreto) {
                System.out.println("numero secreto é menor");
            } else {
                System.out.println("Você Acertou!");
                break;
            }
            System.out.println("você tem " + (5-i) + " tentativas");
            i++;
        }
        if (i == 5){
            System.out.println("Você não conseguiu :(");
        }

    }
}
