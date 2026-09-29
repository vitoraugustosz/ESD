package ads.esd;

public class Processador {

    Requisicao requisicao;

    public Processador(){

    }

    public double processar(Requisicao requisicao) {
        this.requisicao = requisicao;
        return Math.sqrt(Math.cos(requisicao.parseDouble()));
    }

    public int getRequisicao() {
        return requisicao.parseInt();
    }

    public void setRequisicao(Requisicao requisicao) {
        this.requisicao = requisicao;
    }
}
