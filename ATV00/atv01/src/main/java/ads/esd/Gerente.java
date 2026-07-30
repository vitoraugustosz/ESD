package ads.esd;

public class Gerente extends Funcionario {

    private double bonus;

    public Gerente(double salarioBase, String nome, String cpf) {
        super(salarioBase, nome, cpf);
    }

    public double calcularBonus(int quantidadeFuncionarios) {
        return this.getSalario() * 0.1 * quantidadeFuncionarios;
    }

}
