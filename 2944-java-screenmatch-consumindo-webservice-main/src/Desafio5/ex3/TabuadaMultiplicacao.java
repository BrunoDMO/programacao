package Desafio5.ex3;

public class TabuadaMultiplicacao implements Tabuada {
    private int numero;

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public void mostrarTabuada() {
        System.out.println("Tabuada do "+ this.numero);
        for (int i=1; i<11;i++){
            System.out.println(this.numero+"*"+i+"= "+this.numero*i);
        }
    }
}
