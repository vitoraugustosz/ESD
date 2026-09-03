package vetor.testes;

import vetor.Produto;
import vetor.Vetor;

public class ex13 {

    static void main() {

        Vetor<Produto> estoque = new Vetor<>(10);
        estoque.inserirOrdenado(new Produto(1,"Notebook", 3500));
        estoque.inserirOrdenado(new Produto(2,"Teclado", 200));
        estoque.inserirOrdenado(new Produto(3,"Mouse", 50));
        estoque.imprimir();




    }
}
