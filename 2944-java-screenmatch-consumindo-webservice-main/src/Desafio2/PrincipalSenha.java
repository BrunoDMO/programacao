package Desafio2;

import Desafio2.exception.SenhaLimiteAtingido;

import java.util.Scanner;

public class PrincipalSenha {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite senha de 8 digitos");
        String senhaGrab = leitura.next();
        try {
            //way to validate the senha with other method;
            //validarSenha(senha);

            //way to validate the senha checking if the class has the requirements
            Senha senha = new Senha(senhaGrab);
            System.out.println("Registro de senha com sucesso!");

        }catch (SenhaLimiteAtingido elemento){
            System.out.println("Erro: "+elemento.getMensagem());
        }
    }

    private static void validarSenha(String senha) {
        if (senha.length() > 8){
            throw new SenhaLimiteAtingido();
        }
    }
}

