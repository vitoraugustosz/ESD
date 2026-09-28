package ads.esd;

import java.util.Arrays;

public class Vetor<T extends Comparable<T>> {
    private T[] vetor;
    private int tamanho;

    public Vetor(int capacidade){
        this.tamanho = 0;
        vetor = (T[]) new Comparable[capacidade];
    }

    public void inserir(T valor){
        this.vetor[tamanho] = valor;
        tamanho++;
    }
    public void inserir(T[] bloco){
        for (int i = 0; i < bloco.length; i++) {
            this.vetor[tamanho] = bloco[i];
            tamanho++;
        }
    }

    public void inserirOrdenado(T valor){
        if (tamanho == 0) {
            this.inserir(valor);
            return;
        }

        int indice = pegarPosicao(valor);

        if (indice < 0) {
            vetor[tamanho] = valor;
        } else {
            for (int i = 0; i < tamanho - indice; i++) {
                vetor[tamanho - i] = vetor[tamanho - (i + 1)];
            }
            vetor[indice] = valor;
        }


        tamanho++;
    }

    public int pegarPosicao(T valor) {
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i]==null){break;}
            if ((Integer) vetor[i] >= (Integer) valor){
                return i;
            }
        }
        return -1;
    }


    public void remover(int indice){
        for (int i = 0; i < tamanho-indice; i++) {
            vetor[indice+i] = vetor[indice+(i+1)];
        }
        tamanho--;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vetor:");
        sb.append(Arrays.toString(vetor)).append('\n');
        sb.append("tamanho=").append(tamanho);
        return sb.toString();
    }
}
