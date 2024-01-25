package Desafio4;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal4 {
    public static void main(String[] args) {
        ArrayList<String> listaCeps = new ArrayList<>();
        BuscaCep buscaCep = new BuscaCep();
        GeradorDeArquivo gerador = new GeradorDeArquivo();
        Scanner leitura = new Scanner(System.in);
        String cep = "";
        String busca = "";

        while(!cep.equalsIgnoreCase("sair")){
            System.out.println("Insira CEP");
            cep = leitura.nextLine();
            if (cep.equalsIgnoreCase("sair")) {
                break;
            }
            busca = String.valueOf(buscaCep.buscaEndereco(cep));
            //adiciona a lista de ceps se não for null
            if (!busca.equalsIgnoreCase("null")){
                listaCeps.add(busca);
            }
        }
        gerador.geraArquivo(String.valueOf(listaCeps));
    }
}
