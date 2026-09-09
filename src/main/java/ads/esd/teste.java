package ads.esd;

public class teste {

    static void main(String[] args) {
        Vetor<Contato> lista = new Vetor<>(3);

        lista.inserir(new Contato("Vitor", 489962880));
        lista.inserir(new Contato("Joao", 245345333));
        lista.inserir(new Contato("Joana", 434985));
        lista.inserir(new Contato("Valeria", 943578));
        lista.inserir(new Contato("Ana", 93485348));
    }
}
