package ads.esd;

import java.util.NoSuchElementException;


public class Lista {

    private final Contato[] lista;
    private int tamanho;

    public Lista(int tamanho) {
        lista = new Contato[tamanho];
    }



    public void adicionarContato(Contato contato) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == null){
                this.add(contato); //manda colocar esse contato na lista
                break;
            }
            if (lista[i].getNome().equals(contato.getNome())){
                throw new ContatoExistenteException("Este contato já existe");
            }
            if (lista[i].getNumero().equals(contato.getNumero())){
                throw new ContatoExistenteException("Este contato já existe");
            }
        }
        }



    public void adicionarContatos(Contato[] array) {

        if (array.length + tamanho > lista.length) {
            throw new IndexOutOfBoundsException("Ultrapassa o tamanho da array");
        } else {
            for (Contato contato : array) {
                adicionarContato(contato);
            }
        }
    }



    protected void add (Contato c) { // coloca o contato na lista. Usuário não tem acesso
        if (tamanho < lista.length) {
            lista[tamanho] = c;
            tamanho++;
        } else {
            throw new IndexOutOfBoundsException("Vetor está cheio");
        }
    }

    public void remove(int indice) { 
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        for (int i = indice; i < tamanho; i++) {
            lista[i] = lista[i+1];

        }
        lista[tamanho-1] = null; // acessa o último valor, não acessado e deixa nulo
        tamanho--; // atualiza valor do tamanho
    }

    public void remove(String nome){//tira o contato pelo nome (tira fulano)
        for (int j = 0; j < lista.length; j++) {
            if (lista[j].getNome().equals(nome)){ //pega o indice e manda pra oura
                remove(j);
            }
        }
    }

    public Contato get(String nomeOuNumero){ //get, pega um contato na lista
        for (Contato contato : lista) {
            if (contato.getNome().equalsIgnoreCase(nomeOuNumero)){
                return contato;
            } else if (contato.getNumero().equalsIgnoreCase(nomeOuNumero)) {
                return contato;
            }
        }
        return null;
    }

    public int getContatoIndex(Contato contato){ //retorna o indice do contato 
        for (int i = 0; i < lista.length; i++) {
            if (lista[i].getNumero().equalsIgnoreCase(contato.getNumero()) && lista[i].getNome().equalsIgnoreCase(contato.getNome())) {
                return i;
            }
        }
       throw new NoSuchElementException("Valor inexistente");

    }

    public void atualize(Contato contato, String nome, String numero){ //sem email
        int index = getContatoIndex(contato);
        lista[index].setNome(nome);
        lista[index].setNumero(numero);
    }

    public void atualize(Contato contato, String nome, String numero, String email){ //com email
        int index = getContatoIndex(contato);
        lista[index].setNome(nome);
        lista[index].setNumero(numero);
        lista[index].setEmail(email);
    }

    public String list(){
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de contatos").append("\n");

        for (int i = 0; i < lista.length; i++) {
            if (lista[i] == null) {
                sb.append("\n");
            } else {
                sb.append(lista[i].getNome()).append(" - ").append(lista[i].getNumero()).append("\n");

            }
        }
        return sb.toString();
    }

    


}
