package ads.esd;

import java.util.Stack;

public class Escalonador {
    private Stack<Processo> fila;
    private int tempo;
    private Processo[] processos;

    public Escalonador(Processo[] processos){
        this.tempo = 0;
        fila = new Stack<>();
        this.processos = processos;
    }

    public void main(){
        addProcesso();
        while (!fila.empty()){
            processar();
            avancarTempo();
            addProcesso();
        }
    }

    public int avancarTempo(){
        this.tempo++;
        return this.tempo;
    }

    public void processar(){
        Processo p = fila.pop();

        if (p.getTempoChegada() <= this.tempo){
            p.setStatus("EXECUTANDO");
            System.out.printf("%s executando... \n", p.getNome());
            p.processar();

            if (p.getInstrucoesRestantes() <= 0) {
                p.setStatus("TERMINADO");
                System.out.printf("%s executou 1 instrução \n", p.getNome());
                return;
            }
            System.out.printf("%s executou 2 instruções \n", p.getNome());
            fila.push(p);
        } else {
            fila.push(p);
        }

    }

    public void addProcesso(){
        for (int i = 0; i < processos.length; i++) {
            if (processos[i] == null) {
                break;
            }
            if (tempo == processos[i].getTempoChegada()){
                fila.push(processos[i]);
                System.out.printf("Tempo %d: %s chegou e entrou na fila \n", tempo, processos[i].getNome());
                processos[i] = null;
            }
        }
    }

}
