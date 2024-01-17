package Desafio1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Principal1 {
    public static void main(String[] args) {
        //********************************************Pessoa
//        String jsonPessoa = "{\"nome\":\"Rodrigo\",\"idade\":20,\"cidade\":\"Brasília\"}";
//        System.out.println(jsonPessoa);
//
//        Gson gson = new GsonBuilder()
//                .setLenient()
//                .create();
//
//        Pessoa pessoa1 = gson.fromJson(jsonPessoa, Pessoa.class);
//
//        System.out.println("Pessoa: " + pessoa1);
        //********************************************Livro (Conversao Json Aninhado Para Objeto)
        String jsonLivro = "{\"titulo\":\"Aventuras do Java\",\"autor\":\"Akemi\",\"editora\":{\"nome\":\"TechBooks\",\"cidade\":\"São Paulo\"}}";
        System.out.println(jsonLivro);

        Gson gson = new Gson();

        Livro livro1 = gson.fromJson(jsonLivro, Livro.class);

        System.out.println("Livro: " + livro1);





    }
}
