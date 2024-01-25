package Desafio4;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {
    public void geraArquivo(String listaCEP){
        try {
            FileWriter file = new FileWriter("CEPs.txt");
            file.write("Lista de CEPs:\n");
            file.write(listaCEP);
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
