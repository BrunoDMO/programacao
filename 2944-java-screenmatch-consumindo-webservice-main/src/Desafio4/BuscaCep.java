package Desafio4;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BuscaCep {
    public String buscaEndereco(String cep) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String apiResposta = this.sendReceive(cep);
        //filtra só oque quer do json
        RecordCep filterCep = gson.fromJson(apiResposta, RecordCep.class);
        //transoforma em arquivo json novamente
        String jsonCEP = gson.toJson(filterCep);
        return jsonCEP;
    }

    public String sendReceive(String cep){
        String endereco = "https://viacep.com.br/ws/" + cep + "/json/";
        String resposta = "";
        try {
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
            resposta = response.body();
        }catch (CepNaoEncontradoException e) {
            System.out.println(e.getMensagem());
        }catch (IOException | InterruptedException | JsonSyntaxException e) {
            throw new RuntimeException(e.getMessage());
        }
        return resposta;
    }
}
