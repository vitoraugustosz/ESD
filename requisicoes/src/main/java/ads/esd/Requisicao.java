package ads.esd;

import java.util.Random;

public class Requisicao implements Comparable {
    static int id;
    private int info;
    private Random r = new Random();

    public Requisicao(){
        this.id = id++;
        this.info = r.nextInt( 9999999);
    }

    public Random getR() {
        return r;
    }

    public int parseInt(){
        return info;
    }

    public double parseDouble(){
        return info;
    }

    public void setR(Random r) {
        this.r = r;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Requisicao.id = id;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
