package ads.esd.vetor.Testes;

import ads.esd.vetor.VetorEstatico;

public class ex3 {
    static void main() {
        VetorEstatico vetor = new VetorEstatico(10);

        array[2] = "A";
        vetor.inserir("A");
        vetor.inserir("B");
        vetor.inserir("C");
        vetor.inserir("D");
        vetor.inserir("E");
        vetor.inserir("F");

        vetor.imprimir();

        System.out.println("removendo posição 3");
        vetor.remover(2);

        System.out.println("Após remoção");
        vetor.imprimir();


    }
}
