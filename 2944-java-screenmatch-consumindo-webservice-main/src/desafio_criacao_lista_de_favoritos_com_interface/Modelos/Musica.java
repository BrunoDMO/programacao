package desafio_criacao_lista_de_favoritos_com_interface.Modelos;

import desafio_criacao_lista_de_favoritos_com_interface.Interface.Avaliavel;

public class Musica extends Audio implements Avaliavel {
    private String artista;
    private String genero;

    public Musica(
            String titulo,
            int duracao,
            int totalDeReproducoes,
            int curtidas,
            String classificacao,
            String artista,
            String genero)
    {
        super(titulo, duracao, totalDeReproducoes, curtidas, classificacao);
        this.artista = artista;
        this.genero = genero;
    }


    @Override
    public void curtida(ListaCurtidas lista) {
        lista.addList(this);
        System.out.println("Musica curtida!");

    }

    @Override
    public void reproducao() {
        System.out.println("Musica :"+getTitulo());
        System.out.println("Artista: "+this.artista);
        System.out.println("Gênero: "+this.genero);
        System.out.println("Duração: "+getDuracao()+" minutos");
    }

    @Override
    public String toString() {
        return "Musica{" +
                "artista= " + artista +
                ", genero= " + genero +
                ", curtidas= " + this.getCurtidas() +
                ", duração= " + this.getDuracao() + " minutos" +
                '}';
    }
}
