package Desafio4;

public class CepNaoEncontradoException extends RuntimeException {
    private String mensagem;
    public CepNaoEncontradoException(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return this.mensagem;
    }
}
