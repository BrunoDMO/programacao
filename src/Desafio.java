import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        double valorInicial = 2500;

        String nome = "Bruno Oliveira";
        String tipoConta = "Poupança";
        double saldo = valorInicial;

        String menu = """
                Operações
                                
                1- Consultar saldos
                2- Receber valor
                3- Transferir valor
                4- Sair
                """;

        System.out.println(String.format("""
                ***********************
                Dados iniciais do cliente:
                                
                Nome: %s
                Tipo conta: %s
                Saldo inicial: R$ %.2f 
                ***********************
                """, nome, tipoConta, valorInicial));

        System.out.println(menu);
        int operacao = 0;
        while (operacao != 4) {
            System.out.println("Digite a opção desejada:");
            operacao = leitura.nextInt();

            switch (operacao) {
                case 1:
                    System.out.println("Saldo: R$" + saldo);
                    break;
                case 2:
                    System.out.println("Valor a receber: ");
                    double valorReceber = leitura.nextInt();
                    saldo += valorReceber;
                    System.out.println("Novo Saldo: R$" + saldo);
                    break;
                case 3:
                    System.out.println("Valor a transferir: ");
                    double valorTransferir = leitura.nextInt();
                    while (valorTransferir > saldo) {
                        System.out.println("Saldo insuficiente, digite um valor valido");
                        valorTransferir = leitura.nextInt();
                    }
                    saldo -= valorTransferir;
                    System.out.println("Novo Saldo: R$" + saldo);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Operação invalida");
                    System.out.println(menu);
            }

        }
    }
}
