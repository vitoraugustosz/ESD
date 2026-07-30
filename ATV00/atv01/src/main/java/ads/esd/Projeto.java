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
        
        custo[0] += gerente.getSalario() + gerente.calcularBonus(equipe.size());
        // adicionar salario do gerente + bonus por funcionario

        this.custoTotal = custo[0]; // atualizar valor
        return custo[0];
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
         if (aberto) {
            this.nome = nome;
         }
         return;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        if (aberto) {
        this.gerente = gerente;
        }
        return;
    }

    public ArrayList<Funcionario> getEquipe() {
        return equipe;
    }

    public int getEquipeSize(){
        return equipe.size();
    }

    public void setEquipe(ArrayList<Funcionario> equipe) {
         if (aberto) {
        this.equipe = equipe;
         }
         return;
    }

    public double getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(double custoTotal) {
         if (aberto) {
        this.custoTotal = custoTotal;
         }
         return;
    }

    public void finalizar(){
        if (aberto) {
            this.equipe.forEach(f -> {
                f.addBonusSalario(f.getSalario()*0.1);
            });
            calcularCusto(); //atualiza o valor
            this.aberto = false;
        }
        return;
    }

    public boolean isAberto() {
        return this.aberto;
    }

    public boolean addFuncionario(Funcionario funcionario){
        if (this.aberto){
            this.equipe.add(funcionario);
            this.custoTotal = calcularCusto(); //atualiza o valor
            return true;
        }
        return false;
    }

    public boolean removeFuncionario(Funcionario funcionario){
        if (this.aberto){
            if(this.equipe.contains(funcionario)){
                this.equipe.remove(funcionario);
            this.custoTotal = calcularCusto(); //atualiza o valor
            return true;
            }
            return false;
            
        }
        return false;
    }

    public String listarEquipe(){
        StringBuilder sb = new StringBuilder();
        sb.append("Equipe do projeto ").append(this.nome).append(":\n");
        sb.append("Gerente: ").append(this.gerente.getNome()).append("\n");
        for (Funcionario funcionario : equipe) {
            sb.append(funcionario.toString()).append("\n");
        }
        return sb.toString();
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
