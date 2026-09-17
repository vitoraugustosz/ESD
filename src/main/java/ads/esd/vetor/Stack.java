package ads.esd.vetor;

import ads.esd.Vetor;

public class Stack <T extends Comparable<T>>{


    private Vetor<T> vetor;

    public Stack (int capacidade){
        vetor = new Vetor<>(capacidade);
    }

    public void push(T elemento) {
        vetor.inserir(elemento);
    }

    public boolean isEmpty(){

        return vetor.obterTamanho() == 0; //retorna falso se o topo for zero
    }

    public T pop(){
        if (isEmpty()){
            throw new RuntimeException("Pilha Vazia");
        }
        T valor = vetor.ler(vetor.obterTamanho()-1);
        vetor.remover(vetor.obterTamanho()-1);
        return valor;
    }

    public T peek(){
        if (isEmpty()){
            throw new RuntimeException("Pilha Vazia");
        }

        return vetor.ler(vetor.obterTamanho()-1);
    }
}
