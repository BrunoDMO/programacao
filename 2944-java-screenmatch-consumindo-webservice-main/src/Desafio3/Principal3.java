package Desafio3;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class Principal3 {
    public static void main(String[] args) throws IOException {
        //cria o Gson
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        //cria o arquivo que será escrito
        FileWriter file = new FileWriter("arquivo.txt");
        //escreve no arquivo
        file.write("Conteúdo a ser gravado no arquivo.\n");

        //cria os objetos de classe Titulo e Veiculo e converte para json
        Titulo titulo = new Titulo("Abracadraba", 2005);
        String jsonTitulo = gson.toJson(titulo);
        Veiculo veiculo = new Veiculo(2020,"volksvagem");
        String jsonVeiculo = gson.toJson(veiculo);

        //escreve os objetos convertidos para json no arquivo.txt
        file.write(jsonTitulo);
        file.write(jsonVeiculo);

        //termina de escrever no arquivo
        file.close();
    }
}
