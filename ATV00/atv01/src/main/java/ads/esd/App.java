package ads.esd;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {

    private ArrayList<Funcionario> quadro = new ArrayList<>();
    private ArrayList<Projeto> projetos = new ArrayList<>();

    public App() {
        App app = new App();
    }


    public static void main(String args[]){

    }

    public void menu(){
        int entrada = Integer.parseInt(IO.readln("""
                Bem-vindo ao sistema de gerenciamento de projetos
                
                O que pretende fazer?
                
                1 - Cadastrar funcionario
                2 - Cadastrar gerente
                3 - Iniciar projeto
                4 - Listar projetos
                5 - Listar quadro de colaboradores
                6 - Finalizar projeto
                7 - Finalizar
                
                
                
                """));


        separarOpcoes(entrada);

    }

    public void separarOpcoes(int entrada){

        switch (entrada){
            case 1 -> cadastrarFuncionario();
            case 2 -> cadastrarGerente();
            case 3 -> iniciarProjeto();
            case 4 -> listarProjetos();
            case 5 -> listarQuadro();
            case 6 -> finalizarProjeto();
            case 7 -> {
                return;
            }
            default -> {
                System.out.println("Opção inválida");
                menu();
            }
        }
    }

    public void cadastrarFuncionario() {
        String i;
        do {
            i = "";
            String nome = IO.readln("Digite o nome do funcionário: ");

            String cpf = IO.readln("Digite o cpf do usuario");
            double salario = Double.parseDouble(IO.readln("O salário base desse funcionário, apenas com números e pontos para centavos"));

            Funcionario novoFuncionario = new Funcionario(salario, nome, cpf);
            this.quadro.add(novoFuncionario);

            i = IO.readln("Cadastrar novo funcionário?");

        } while (!(i.equals("")));

    }

    public void cadastrarGerente() {
        String i;
        do {
            i = "";
            String nome = IO.readln("Digite o nome do gerente: ");

            String cpf = IO.readln("Digite o cpf do usuario");
            double salario = Double.parseDouble(IO.readln("O salário base desse gerente, apenas com números e pontos para centavos"));

            Gerente novoGerente = new Gerente(salario, nome, cpf);
            this.quadro.add(novoGerente);

            i = IO.readln("Cadastrar novo gerente?");

        } while (!(i.equals("")));

    }

    public void iniciarProjeto(){
        String nomeProjeto = IO.readln("Digite o nome do projeto desejado");
        Funcionario[] gerente = new Gerente[1];
        String nomeGerente = IO.readln("digite o nome do gerente da equipe");
        quadro.forEach(f -> {
            if (f.getNome().equals(nomeGerente)){
                gerente[0] = f;
            }
        });
        ArrayList<Funcionario> equipe = new ArrayList<>();
        String i;
        do {
            i = "";
            String nome = IO.readln("Digite o nome do funcionário para adicionar ao projeto");
            quadro.forEach(f -> {
                if (f.getNome().equals(nome)){
                    equipe.add(f);
                }
            });
            i = IO.readln("Deseja adicionar outro funcionário ao projeto? S (Sim) / N (Não)");
        } while(i.equalsIgnoreCase("S"));

        Projeto novoProjeto = new Projeto(nomeProjeto, gerente[0], equipe);
    }




}
