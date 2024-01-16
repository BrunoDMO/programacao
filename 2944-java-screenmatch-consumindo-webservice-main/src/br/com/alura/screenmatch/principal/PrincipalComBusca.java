package br.com.alura.screenmatch.principal;

import br.com.alura.screenmatch.modelos.Titulo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        HttpClient client = HttpClient.newHttpClient();
        System.out.println("nome do filme:");
        var busca = leitura.nextLine();
        var apiKey = "4d4da9d1";
        String endereco = "https://www.omdbapi.com/?t="+busca+"&apikey="+apiKey;


        //faz request na api
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();

        //pega o conteudo que o request obteve
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        String json = response.body();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
        TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
        System.out.println(meuTituloOmdb);
        //converte tituloOmdb para formato titulo
        Titulo meuTitulo = new Titulo(meuTituloOmdb);
        //printa convertido
        System.out.println(meuTitulo);



//        //***********************************************************Livro
//        System.out.println("Nome do Livro");
//        var buscaLivro = leitura.nextLine();
//        var apiKey2 = "AIzaSyB88RO8w4Bbl9zG7iK7r_h7YKmdGoerGXI";
//        var endereco2 = "https://www.googleapis.com/books/v1/volumes?q="+ buscaLivro +"&key="+ apiKey2 + "&fields=kind,items(volumeInfo/title,saleInfo/buyLink,saleInfo/listPrice)";
//
//        //faz request na api
//        HttpRequest request2 = HttpRequest.newBuilder()
//                .uri(URI.create(endereco2))
//                .build();
//
//        //pega o conteudo que o request obteve
//        HttpResponse<String> response2 = client
//                .send(request2, HttpResponse.BodyHandlers.ofString());
//
//        //printa o corpo do json
//        String json = response2.body();
//        System.out.println(json);



        //***********************************************************Comida

//        System.out.println("Nome da Comida");
//        var buscaComida = leitura.nextLine();
//        var apiKey3 = 1;
//        var endereco3 = "https://www.themealdb.com/api/json/v1/1/search.php?s="+buscaComida+"&key="+apiKey3;
//
//        //faz request na api
//        HttpRequest request3 = HttpRequest.newBuilder()
//                .uri(URI.create(endereco3))
//                .build();
//
//        //pega o conteudo que o request obteve
//        HttpResponse<String> response3 = client
//                .send(request3, HttpResponse.BodyHandlers.ofString());
//        System.out.println(response3.body());
//
//
    }
}
