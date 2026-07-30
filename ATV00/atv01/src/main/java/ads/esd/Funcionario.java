package ads.esd;

public class Funcionario {
    private String cpf;
    private String nome;
    private double salarioBase;

    public Funcionario(double salarioBase, String nome, String cpf) {
        this.salarioBase = salarioBase;
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salarioBase;
    }

    public void setSalario(double salario) {
        this.salarioBase = salario;
    }

    public void addBonusSalario(double bonus) {
        this.salarioBase += bonus;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Funcionario{");
        sb.append("cpf=").append(cpf);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", salarioBase=").append(salarioBase);
        sb.append('}');
        return sb.toString();
    }
}
