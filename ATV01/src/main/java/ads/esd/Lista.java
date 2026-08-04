package ads.esd;

import javax.management.InstanceAlreadyExistsException;

public class Lista {

    private Contato[] lista;
    private int tamanho;

    public Lista(int tamanho) {
        this.tamanho = tamanho;
    }

    public void adicionarContato(Contato contato) {
        for (Contato c : lista){
            if (c.getNome().equals(contato.getNome())){
                throw new ContatoExistenteException("Este contato já existe");
            }
            if (c.getNumero().equals(contato.getNumero())){
                throw new ContatoExistenteException("Este contato já existe");
            }
            else {
                this.add(contato);
            }
        }
    }

    protected void add (Contato c) {
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

    public void remove(String nome){
        for (int j = 0; j < lista.length; j++) {
            if (lista[j].getNome().equals(nome)){
                remove(j);
            }
        }
    }

    public Contato get(String nomeOuNumero){
        for (Contato contato : lista) {
            if (contato.getNome().equalsIgnoreCase(nomeOuNumero)){
                return contato;
            } else if (contato.getNumero().equalsIgnoreCase(nomeOuNumero)) {
                return contato;
            }
        }
        return null;
    }

    public String list(){
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de contatos").append("\n");

        for (Contato c : lista){
            sb.append(c.getNome()).append(" - ").append(c.getNumero()).append("\n");
        }

        return sb.toString();
    }



}
