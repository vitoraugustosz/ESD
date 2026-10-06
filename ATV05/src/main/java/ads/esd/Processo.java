package ads.esd;

import java.util.Random;

public class Processo implements Comparable<Processo> {
    private String nome;
    private int instrucoesRestantes;
    private int tempoChegada;
    private String status;
    private Random r = new Random();

    public Processo(String nome, int numInstrucoes, int tempoChegada){
        this.nome = nome;
        this.instrucoesRestantes = numInstrucoes;
        this.tempoChegada = tempoChegada;
    }

    public void processar(){
        this.instrucoesRestantes--;
        this.status = "PRONTO";
    }

    public int getInstrucoesRestantes() {
        return instrucoesRestantes;
    }

    public void setInstrucoesRestantes(int instrucoesRestantes) {
        this.instrucoesRestantes = instrucoesRestantes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTempoChegada() {
        return tempoChegada;
    }

    public void setTempoChegada(int tempoChegada) {
        this.tempoChegada = tempoChegada;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public int compareTo(Processo o) {
        return 0;
    }
}
