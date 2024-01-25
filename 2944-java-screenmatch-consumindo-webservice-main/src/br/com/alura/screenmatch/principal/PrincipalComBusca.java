package br.com.alura.screenmatch.principal;

import Desafio2.exception.ErroConsultaGitHubException;
import br.com.alura.screenmatch.exception.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class PrincipalComBusca {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        HttpClient client = HttpClient.newHttpClient();
        ArrayList<Titulo> titulos = new ArrayList<>();
        var busca = "";
        var apiKey = "4d4da9d1";

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        while(!busca.equalsIgnoreCase("sair")) {


            System.out.println("nome do filme:");
            busca = leitura.nextLine();
            if (busca.equalsIgnoreCase("sair")){
                break;
            }
            try {
                String endereco = "https://www.omdbapi.com/?t="+busca.replace(" ","+")+"&apikey="+apiKey;
                //faz request na api
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(endereco))
                        .build();

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

//                if (response.statusCode() == 404) {
//                    throw new ErroConsultaGitHubException("Usuário não encontrado no GitHub.");
//                }
                String json = response.body();

                TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                System.out.println(meuTituloOmdb);
                //converte tituloOmdb para formato titulo
                Titulo meuTitulo = new Titulo(meuTituloOmdb);
                //printa convertido
                System.out.println(meuTitulo);
                titulos.add(meuTitulo);

            } catch (IllegalArgumentException elemento) {
                System.out.println(ANSI_RED + "endereço invalido" + ANSI_RESET);
            } catch (ErroDeConversaoDeAnoException elemento) {
                System.out.println(ANSI_RED + "Ocorreu um erro: " + elemento.getMensagem() + ANSI_RESET);
            } catch (NullPointerException elemento) {
                System.out.println(ANSI_RED + "Filme não encontrado" + ANSI_RESET);
            }
            System.out.println(ANSI_GREEN + "Programa finalizou com sucesso!" + ANSI_RESET);
        }
        System.out.println(titulos);
        FileWriter escrita = new FileWriter("Filme.txt");
        escrita.write(gson.toJson(titulos));
        escrita.close();


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
