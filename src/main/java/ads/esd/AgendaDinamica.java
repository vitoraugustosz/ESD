package ads.esd;

import javax.lang.model.type.NullType;

public class AgendaDinamica {

    private Vetor<Contato>[] listaNomes = new Vetor[26];

    public AgendaDinamica(){
    }

    public boolean inserir(Contato contato){
        String nome = contato.getNome().toUpperCase();
        char primeiraLetra = nome.charAt(0);
        int indice = (primeiraLetra < 91 && primeiraLetra >= 65) ? primeiraLetra - 65 : -1;


        if (indice<0) {
            return false; // nome inválido
        }



        if (listaNomes[indice] == null){
            listaNomes[indice] = new Vetor<>(5); // instanciar de acordo com a demanda evita ocupar memória desnecessariamente
        } else {
            listaNomes[indice].inserirOrdenadov2(contato);
        }
        return true; // deu certo
    }

    public int getIndice(String nome){
        char primeiraLetra = nome.toUpperCase().charAt(0);
        return primeiraLetra-65;
    }

    public void remover(String nome){
        int primeiraLetra = nome.toUpperCase().charAt(0);
        int indiceletra = primeiraLetra - 65;
        int posicaoContato = encontrarPorNome(nome, indiceletra); // pega o indice do contato desejado no vetor da letra dele a partir apenas da String nome

        listaNomes[indiceletra].remover(posicaoContato); // remove

    }

    public int encontrarPorNome(String nome, int indice){
            Vetor<Contato> vetor = listaNomes[indice];
            int inicio = 0;
            int fim = vetor.obterTamanho();

            while (inicio <= fim) { // BUSCA BINARIA

                int meio = (inicio + fim)/2;

                if (vetor.ler(meio).compareTo(nome) == 0) { // Se o valor for igual ao desejado
                    return meio;
                }  else if (vetor.ler(meio).compareTo(nome) > 0) { // Se alfabeticamente o valor do meio for maior (mais perto do fim do alfabeto) que o desejado
                    fim = meio -1;
                } else { // se o objeto do meio estiver antes, alfabeticamente, que o valor desejado
                    inicio = meio + 1;
                }



            }
        return -1; // deu erro
    }

}
