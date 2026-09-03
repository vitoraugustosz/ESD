package ads.esd.vetor.Testes;

import ads.esd.vetor.Produto;
import ads.esd.vetor.Vetor;

public class ex10 {

    static void main() {

    Vetor<Produto> estoque = new Vetor<>(10);


    estoque.inserir(new Produto(1,12.99, "coisa 1"));
    estoque.inserir(new Produto(4,12.99, "coisa 2"));
    estoque.inserir(new Produto(2,12.99, "coisa 3"));
    estoque.inserir(new Produto(3,12.99, "coisa 4"));
    estoque.inserir(new Produto(5,12.99, "coisa 5"));

    estoque.imprimir();

    }

}
