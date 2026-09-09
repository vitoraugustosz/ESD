package ads.esd;

public class Contato implements Comparable<Contato> {

    private String nome;
    private Vetor<Long> numeros = new Vetor<Long>(2);
    private String email;

    public Contato(String nome, long numero){
        this.nome = nome;
        this.numeros.inserir(numero);
    }

    public Contato(String nome, long numero, String email){
        this.nome = nome;
        this.numeros.inserir(numero);
        this.email = email;
    }

    public Contato(String nome, long numeroPessoal, long numeroComercial, String email){
        this.nome = nome;
        this.numeros.inserir(numeroPessoal);
        this.numeros.inserir(numeroComercial);
        this.email = email;
    }

    public Contato(String nome, long numeroPessoal, long numeroComercial){
        this.nome = nome;
        this.numeros.inserir(numeroPessoal);
        this.numeros.inserir(numeroComercial);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Vetor<Long> getNumeros() {
        return numeros;
    }

    public void setNumeros(Vetor<Long> numeros) {
        this.numeros = numeros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Override
    public int compareTo(Contato contato) {
        return this.nome.compareTo(contato.getNome()); // -1 se this for menor, 0 se igual, 1 se maior
    }

    public int compareTo(String nome) {
        return this.nome.compareTo(nome); // -1 se this for menor, 0 se igual, 1 se maior
    }
}
