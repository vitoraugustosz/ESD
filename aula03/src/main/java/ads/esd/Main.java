package ads.esd;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {

        Produto a = new Produto(1, "Coisa", 12.99);
        Produto b = new Produto(3, "Objeto", 17.99);
        Produto c = new Produto(2, "Coisa", 22.30);


        Vetor v = new Vetor<Produto>(5);

        v.inserirOrdenado(a);
        v.inserirOrdenado(b);
        v.inserirOrdenado(c);

        System.out.println(v);

    }
}
