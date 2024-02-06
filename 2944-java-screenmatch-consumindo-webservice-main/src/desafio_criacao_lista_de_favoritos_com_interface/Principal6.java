package desafio_criacao_lista_de_favoritos_com_interface;

import desafio_criacao_lista_de_favoritos_com_interface.Modelos.ListaCurtidas;
import desafio_criacao_lista_de_favoritos_com_interface.Modelos.Musica;
import desafio_criacao_lista_de_favoritos_com_interface.Modelos.Podcast;

public class Principal6 {
    public static void main(String[] args) {
        //create the favorite list
        ListaCurtidas listaCurtidas = new ListaCurtidas();

        //create the music and podcasts
        Musica musica = new Musica(
                "HouseParty",
                20,
                200,
                400,
                "+10",
                "Popai",
                "House-Pop");
        Musica musica2 = new Musica(
                "HouseBass",
                22,
                400,
                800,
                "+10",
                "Popai",
                "House-Pop");
        Podcast podcast = new Podcast(
                "Gingadinhas",
                120,
                5500,
                2000,
                "+18",
                "Jorge da Borracharia",
                "Cleitão Encanador"
        );

        //.curtida(favoriteList)  : add music to the favorite list
        //.reproducao()           : give a resume of what is the music or podcast
        //.mostraLista()          : shows the favorite list content

        //Add musics and podcast to the favorite list
        musica.curtida(listaCurtidas);
        musica2.curtida(listaCurtidas);
        podcast.curtida(listaCurtidas);

        //Shows status of the music of podcast
        podcast.reproducao();

        //Shows the like list
        listaCurtidas.mostraLista();

    }
}
