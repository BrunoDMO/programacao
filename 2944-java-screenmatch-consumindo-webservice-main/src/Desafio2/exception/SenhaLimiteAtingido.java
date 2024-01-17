package Desafio2.exception;
//RunTimeException is used for unchecked erros, means that do not trigger on compilation.
public class SenhaLimiteAtingido extends RuntimeException {
    private String mensagem = "Senha possui mais de 8 digitos";

    public String getMensagem() {
        return this.mensagem;
    }
}
