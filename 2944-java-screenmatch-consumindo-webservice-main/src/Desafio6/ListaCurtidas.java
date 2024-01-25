package Desafio6;

import java.util.ArrayList;

public class ListaCurtidas {
    private ArrayList<Audio> musicasCurtidas = new ArrayList<Audio>();

    public ArrayList<Audio> getMusicasCurtidas() {
        return musicasCurtidas;
    }

    public void addList(Audio audio){
        musicasCurtidas.add(audio);
    }

    public void mostraLista(){
        System.out.println("***************** Lista De Curtidos ****************");
        for (Audio audio:this.musicasCurtidas) {
            System.out.println(audio.toString());
        }
        System.out.println("******************** Fim Da Lista ******************");
    }
}
