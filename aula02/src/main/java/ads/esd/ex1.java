package ads.esd;

public class ex1 {

    static void main() {
        VetorEstatico v = new VetorEstatico(5);

        v.inserir(1, "A");
        v.inserir(2, "b");
        v.inserir(3, "c");

        System.out.println(v.imprimir());
    }

}
