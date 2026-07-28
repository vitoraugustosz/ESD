package ads.esd;

import java.util.ArrayList;

public class Projeto {
    private String nome;
    private Gerente gerente;
    private ArrayList<Funcionario> equipe;
    private double custoTotal;
    private boolean aberto;

    public Projeto(String nome, Gerente gerente, ArrayList<Funcionario> equipe) {
        this.equipe = equipe;
        this.gerente = gerente;
        this.nome = nome;
        this.custoTotal = calcularCusto();
        this.aberto = true;
    }

    public double calcularCusto() {
        // percorrer array de funcionarios e ir somando o salario, e com o tamanho da array, saber o bonus do patrão
        double[] custo = new double[1];
        equipe.forEach(funcionario -> {
            custo[0] += funcionario.getSalario();
        });

        // adicionar salario do gerente + bonus por funcionario
        return custo[0];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public ArrayList<Funcionario> getEquipe() {
        return equipe;
    }

    public int getEquipeSize(){
        return equipe.size();
    }

    public void setEquipe(ArrayList<Funcionario> equipe) {
        this.equipe = equipe;
    }

    public double getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(double custoTotal) {
        this.custoTotal = custoTotal;
    }

    public void finalizarProjeto(){
        this.aberto = false;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Projeto{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", gerente=").append(gerente);
        sb.append(", equipe=").append(equipe);
        sb.append(", custoTotal=").append(custoTotal);
        sb.append('}');
        return sb.toString();
    }
}
