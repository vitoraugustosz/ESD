package ads.esd.vetor.testes;
import ads.esd.vetor.FilaCircular;
public class ex14 {
    static void main(String[] args) {
        FilaCircular<Character> fila = new FilaCircular<>(5);

        fila.enfileirar('A');
        fila.enfileirar('B');
        fila.enfileirar('C');
        fila.enfileirar('D');
        System.out.println(fila);
        fila.desenfileirar();
        System.out.println(fila);
        fila.desenfileirar();
        System.out.println(fila);
        fila.enfileirar('E');
        fila.enfileirar('F');
        System.out.println(fila);
    }
}
