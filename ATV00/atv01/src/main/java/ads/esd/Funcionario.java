package ads.esd;

public class Funcionario {
    private String cpf;
    private String nome;
    private double salario;

    public Funcionario(double salario, String nome, String cpf) {
        this.salario = salario;
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
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Funcionario{");
        sb.append("cpf=").append(cpf);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", salario=").append(salario);
        sb.append('}');
        return sb.toString();
    }
}
