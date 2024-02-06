package desafio_criacao_lista_de_favoritos_com_interface.Modelos;

import desafio_criacao_lista_de_favoritos_com_interface.Interface.Avaliavel;

public class Podcast extends Audio implements Avaliavel {
    private String apresentador;
    private String intrevistado;

    public Podcast(
            String titulo,
            int duracao,
            int totalDeReproducoes,
            int curtidas,
            String classificacao,
            String apresentador,
            String intrevistado)
    {
        super(titulo, duracao, totalDeReproducoes, curtidas, classificacao);
        this.apresentador = apresentador;
        this.intrevistado = intrevistado;
    }


    @Override
    public void curtida(ListaCurtidas lista) {
        lista.addList(this);
        System.out.println("Podcast Curtido!");
    }

    @Override
    public void reproducao() {
        System.out.println("Podcast :"+getTitulo());
        System.out.println("Apresentador: "+this.apresentador);
        System.out.println("Duração: "+getDuracao()+" minutos");

    }

    @Override
    public String toString() {
        return "Podcast{" +
                "apresentador='" + apresentador + '\'' +
                ", intrevistado='" + intrevistado + '\'' +
                ", curtidas= " + this.getCurtidas() +
                ", duração= " + this.getDuracao() + " minutos" +
                '}';
    }
}
