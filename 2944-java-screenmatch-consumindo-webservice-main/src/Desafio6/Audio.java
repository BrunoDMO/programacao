package Desafio6;

import java.util.ArrayList;

public class Audio {
    private String titulo;
    private int duracao;
    private int totalDeReproducoes;
    private int curtidas;
    private String classificacao;

    public Audio(
            String titulo,
            int duracao,
            int totalDeReproducoes,
            int curtidas,
            String classificacao)
    {
        this.titulo = titulo;
        this.duracao = duracao;
        this.totalDeReproducoes = totalDeReproducoes;
        this.curtidas = curtidas;
        this.classificacao = classificacao;
    }


    public int getCurtidas() {
        return curtidas;
    }
    public String getTitulo() {
        return titulo;
    }

    public int getDuracao() {
        return duracao;
    }

    public int getTotalDeReproducoes() {
        return totalDeReproducoes;
    }

    public String getClassificacao() {
        return classificacao;
    }
}
