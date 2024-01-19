package Desafio4;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

public class BuscaCep {
    public ArrayList<String> buscaEndereco(String cep) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        ArrayList<String> listaCeps = new ArrayList<>();
        Scanner leitura = new Scanner(System.in);

        while (!cep.equalsIgnoreCase("sair")) {
            System.out.println("Insira CEP:");
            cep = leitura.nextLine();
            if (cep.equalsIgnoreCase("sair")) {
                break;
            }
            try {
                String endereco = "https://viacep.com.br/ws/" + cep + "/json/";
                //cria cliente
                HttpClient cliente = HttpClient.newHttpClient();
                //faz pedido do cliente
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();

                HttpResponse<String> response = cliente
                        .send(request, HttpResponse.BodyHandlers.ofString());

                //codigo 400 é retornado quando o cep não é encontrado
                if (response.statusCode() == 400) {
                    throw new CepNaoEncontradoException("Cep Inválido");
                }


                //filtra só oque quer do json
                RecordCep filterCep = gson.fromJson(response.body(), RecordCep.class);
                //transofmra em arquivo json novamente
                String jsonCEP = gson.toJson(filterCep);
                //adiciona a lista de ceps
                listaCeps.add(String.valueOf(jsonCEP));

            } catch (CepNaoEncontradoException e) {
                System.out.println(e.getMensagem());
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return listaCeps;

    }
}
