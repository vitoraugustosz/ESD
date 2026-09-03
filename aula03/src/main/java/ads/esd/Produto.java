package ads.esd;

public class Produto implements Comparable<Produto>{
    private int id;
    private double preco;
    private String nome;

    public Produto(int id, String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", preco=" + preco +
                ", nome='" + nome + '\'' +
                '}';
    }


    @Override
    public int compareTo(Produto outro){
        return Double.compare(this.preco, outro.preco);
    }
}
