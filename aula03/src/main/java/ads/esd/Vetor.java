package ads.esd;

import java.util.Arrays;
import java.util.Random;

public class Vetor<T> {

    private T[] elementos;
    private int tamanho;
    private Random r = new Random();
    @SuppressWarnings("unchecked")
    public Vetor (int quantidade){
        elementos = (T[]) new Object[quantidade];
        tamanho = 0;
    }


    public void inserir( T elemento) {

        int indice = pegarPosicao((int) elemento);

        if (tamanho == elementos.length) {
            expandir();
        }

        if (indice < 0 || indice > elementos.length) {
            return;
        }

        for (int i = tamanho ; i > indice; i-- ) {
            elementos[i] = elementos[i-1];
        }
        elementos[indice] = elemento;
        tamanho++;
    }


    protected int pegarPosicao(int num) {

        if(tamanho == 0){
            return 0;
        }

        for (int i = 0; i < elementos.length; i++) {
            if (elementos[i] == null){
                return i;
            }
            if ( num == (int) elementos[i]){
                return -1;
            }
            if ( num < (int) elementos[i]){
                return i;
            }
        }
        return tamanho;
    }

//    public void inserir(T elemento) {
//        if (tamanho == elementos.length) {
//            expandir();
//        }
//        elementos[tamanho] = elemento;
//        tamanho++;
//    }
    @SuppressWarnings("unchecked")
    private void expandir() {
        T[] novo = (T[]) new Object[elementos.length * 2];
        for (int i = 0; i < elementos.length; i++) {
            novo[i] = elementos[i];
        }
        elementos = novo;
    }

    public void generate(int qtd) {
        Integer n;
        for (int i = 0; i < qtd; i++) {
            n = r.nextInt(100);
            this.inserir((T)n);
        }
    }

    @SuppressWarnings("unchecked")
    private void reduzir() {
        if (tamanho <= elementos.length/4) {
            T[] novo = (T[]) new Object[elementos.length/2];
            for (int i = 0; i < tamanho; i++) {
                novo[i] = elementos[i];
            }
            elementos = novo;
        }
    }



    public void remover(int indice) {
        if (indice < 0 || indice >= tamanho) {
            System.out.println("Indice Inválido");
            return;
        }
        for (int i = indice; i < tamanho; i++) {
            elementos[i] = elementos[i+1];
        }
        elementos[tamanho-1] = null;
        tamanho--;
        reduzir();
    }


    public int buscaLinear(int alvo){

        for (int i = 0; i < elementos.length; i++) {
            if ((Integer) elementos[i] == alvo){
                return i;
            }
            if ((Integer) elementos[i] > alvo){ // Se passou do número, ele não existe
                return -1;
            }
        }
        return -1;
    }

    public int buscaBinaria(int alvo){
        return
    }

    @Override
    public String toString() {
        return "Vetor{" +
                "elementos=" + Arrays.toString(elementos) +
                ", tamanho=" + tamanho +
                '}';
    }
}
