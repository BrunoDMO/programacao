package Desafio2;

import Desafio2.exception.ErroConsultaGitHubException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalGitHub {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Nome do Usuario do GitHub");
        String usuario = leitura.nextLine();
        String endereco = "https://api.github.com/users/" + usuario;
        try {
            //build the client
            HttpClient client = HttpClient.newHttpClient();
            //make the request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .header("Accept", "application/vnd.github.v3+json")
                    .build();
            //get the response from the request
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 404) {
                throw new ErroConsultaGitHubException("Usuário não encontrado no GitHub.");
            }
            String json = response.body();
            System.out.println(json);

            System.out.println("Finalizado!");

            //Adicione aqui o código para processar o JSON e exibir as informações desejadas
        } catch (IOException | InterruptedException e) {
            System.out.println("Opss… Houve um erro durante a consulta à API do GitHub.");
            e.printStackTrace();
        } catch (ErroConsultaGitHubException e) {
            System.out.println(e.getMessage());
        }

    }
}
