package ads.esd.vetor;

import java.util.Arrays;

public class FilaCircular<T extends Comparable<T>> {

    private T[] elementos;
    private int inicio;
    private int fim;
    private int tamanho;

    public FilaCircular(int capacidade) {
        elementos = (T[]) new Comparable[capacidade];
        tamanho = 0;
        fim = -1;
        inicio = 0;
    }

    public void enfileirar(T elemento) {

        if (tamanho == elementos.length) {
            throw new ArrayIndexOutOfBoundsException("ARRAY CHEIO");
        }

        this.fim = (fim + 1) % elementos.length;
        elementos[fim] = elemento;


        // numerador(elementos.length) * quociente + resto = fim


    }

    public boolean isEmpty() {
        return tamanho == 0;
    }

    public T desenfileirar() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("TÁ VAZIO");
        }
        T valor = elementos[inicio]; // o valor que vai ser removido
        elementos[inicio] = null;

        inicio = (inicio + 1) % elementos.length;
        tamanho--;
        return valor;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("FilaCircular{");
        for (int i = inicio; i < tamanho; i++) {
            int indice = (inicio + i) % elementos.length;
            sb.append(elementos[indice] + " ");
        }
        return sb.toString();
    }
}
