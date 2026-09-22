package ads.esd;

public class Posicao {
    private int x;
    private int y;
    private char simbolo;
    private boolean visitado;

    public Posicao(int x, int y, char simbolo) {
        this.x = x;
        this.y = y;
        this.simbolo = simbolo;
    }

    public Posicao(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }
}
