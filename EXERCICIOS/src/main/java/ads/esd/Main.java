package ads.esd;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[] args) {
        Vetor vetor = new Vetor<Integer>(10);
        System.out.println(vetor.toString());
        vetor.inserirOrdenado(1);
        System.out.println(vetor.toString());
        vetor.inserirOrdenado(6);
        System.out.println(vetor.toString());
        vetor.inserirOrdenado(4);
        System.out.println(vetor.toString());
        vetor.inserirOrdenado(3);
        System.out.println(vetor.toString());
        vetor.inserirOrdenado(5);
        System.out.println(vetor.toString());
        vetor.inserirOrdenado(2);
        System.out.println(vetor.toString());
        vetor.remover(2);
        System.out.println(vetor.toString());
    }
}
