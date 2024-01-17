package Desafio2;

import Desafio2.exception.SenhaLimiteAtingido;

public class Senha {
    private String senha;

    public Senha(String senha) {
         this.senha = senha;
         //if the senha has more than 8 characters throw an error
        if (senha.length() > 8){
            throw new SenhaLimiteAtingido();
        }
    }

}
