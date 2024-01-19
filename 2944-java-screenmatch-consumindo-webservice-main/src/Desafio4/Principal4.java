package Desafio4;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal4 {
    public static void main(String[] args) throws IOException {
        FileWriter file = new FileWriter("CEPs.txt");
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        Scanner leitura = new Scanner(System.in);
        HttpClient cliente = HttpClient.newHttpClient();
        ArrayList<String> listaCeps = new ArrayList<>();

        String cep = "";

        while(!cep.equalsIgnoreCase("sair")){
            System.out.println("Insira CEP:");
            cep = leitura.nextLine();
            if (cep.equalsIgnoreCase("sair")){
                break;
            }
            try {
                String endereco = "https://viacep.com.br/ws/" + cep + "/json/";
                //faz pedido do cliente
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();

                HttpResponse<String> response = cliente
                        .send(request, HttpResponse.BodyHandlers.ofString());

                listaCeps.add(response.body());

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        file.write(String.valueOf(listaCeps));
            

    }
}
