package ads.esd;

import java.util.ArrayList;
import java.util.Random;

public class Servidor {

    private int totalRegGeradas = 0;
    private int totalRegAtendidas = 0;
    private int totalRegPerdidas = 0;
    private Random aleatorio;
    private Fila<Requisicao> fila;
    private ArrayList<Processador> processadores = new ArrayList<>();
    private int numMax;

    public Servidor (int numProcessadores, int numMax, int tamanhoFila){

        while (numProcessadores > 0){ //gera processadores e coloca no array
            Processador p = new Processador();
            assert processadores != null;
            processadores.add(p);
            numProcessadores--;
        }

        this.fila = new Fila<>(tamanhoFila);
        this.numMax = numMax;
    }

    public void executar(int ciclos){

        for (int ciclo = 1; ciclo <= ciclos ; ciclo++) {

            int numReq = aleatorio.nextInt(1, numMax);

            gerarRequisicoes(numReq);

            processar();
        }

    }



    protected void gerarRequisicoes(int numReq){
        for (int i = 0; i < numReq; i++) {
            Requisicao r = new Requisicao();
            totalRegGeradas++;
            if (fila.isFull()){
                totalRegPerdidas++;
            } else {
                fila.enfileirar(r);
            }
        }
    }

    protected void processar(){
        processadores.forEach(processador ->{
            processador.processar(fila.desenfileirar());
            totalRegAtendidas++;
        });
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Servidor:");
        sb.append("\n");
        sb.append("Foram geradas:").append(this.totalRegGeradas).append("\n");
        sb.append("Foram atendidas: ").append(this.totalRegAtendidas).append("\n");
        sb.append("Você perdeu:").append(this.totalRegPerdidas).append("\n");
        sb.append((this.totalRegPerdidas*100)/this.totalRegGeradas).append("% de requisicoes perdidas");

        return sb.toString();
    }
}
