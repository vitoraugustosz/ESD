package ads.esd;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {

    private ArrayList<Funcionario> quadro = new ArrayList<>();
    private ArrayList<Projeto> projetos = new ArrayList<>();

    public App() {
        
    }


    public static void main(String args[]){
                App app = new App();

                int entrada = Integer.parseInt(IO.readln("""
                Bem-vindo ao sistema de gerenciamento de projetos
                
                O que pretende fazer?
                
                1 - Cadastrar funcionario
                2 - Cadastrar gerente
                3 - Iniciar projeto
                4 - Listar projetos
                5 - Listar quadro de colaboradores
                6 - Finalizar projeto
                7 - Acessar projeto
                8 - finalizar programa
                
                
                
                """));


        app.menu(entrada);
        
        return
        
    }

    

    public void menu(int entrada){

        switch (entrada){
            case 1 -> cadastrarFuncionario();
            case 2 -> cadastrarGerente();
            case 3 -> iniciarProjeto();
            case 4 -> listarProjetos();
            case 5 -> listarQuadro();
            case 6 -> finalizarProjeto();
            case 7 -> acessarProjeto();
            case 8 -> System.exit(0);
            default -> {
                System.out.println("Opção inválida");
                return;
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

    public void listarProjetos() {
        System.out.println("Projetos cadastrados:");
        System.out.println(projetos);
    }

    public void listarQuadro() {
        System.out.println("Colaboradores cadastrados:");
        System.out.println(quadro);
    }

    public void finalizarProjeto() {
        String nomeProjeto = IO.readln("Digite o nome do projeto que deseja finalizar");
        projetos.forEach(p -> {
            if (p.getNome().equals(nomeProjeto)){
                p.finalizar();
            }
        });
    }

    public void acessarProjeto() {
        String nomeProjeto = IO.readln("Digite o nome do projeto que deseja acessar");
        Projeto projeto = null;
        projetos.forEach(p -> {
            if (p.getNome().equals(nomeProjeto)){
                projeto = p;
            }
        });

        switch (opcoesProjeto(projeto)) {
            case 1 -> System.out.println(projeto); 
            case 2 -> System.out.println(projeto.listarEquipe());
            case 3 -> substituirGerente(projeto); //so vai acessar o projeto e trocar pelo informado
            case 4 -> adicionarFuncionario(projeto); // bota na array
            case 5 -> removerFuncionario(projeto); // tira da array
            case 6 -> System.out.println(projeto.getCustoTotal());
            case 7 -> projeto.finalizar();
        }

    }

    public int opcoesProjeto(Projeto projeto) {
        int entrada = Integer.parseInt(IO.readln("""
                .:: Projeto %s ::.
                1 - Informações gerais
                2 - Listar equipe
                3 - Substituir gerente
                4 - Adicionar funcionário
                5 - Remover funcionário
                6 - Análise de custo
                7 - Finalizar projeto
                8 - Voltar ao menu principal

                """, projeto.getNome()));

                return entrada;
    }

    public void substituirGerente(Projeto p) {
        String novoGerente = IO.readln("Digite o nome do novo gerente");

        quadro.forEach(f -> {
            if (f.getNome().equalsIgnoreCase(novoGerente)){
                p.setGerente((Gerente) f);
                p.calcularCusto(); // recalcula 
            }
        });
    }

    public void adicionarFuncionario(Projeto p) {
        String novoFuncionario = IO.readln("Digite o nome do novo funcionário");
        quadro.forEach(f -> {
            if (f.getNome().equalsIgnoreCase(novoFuncionario)){
                p.addFuncionario(f);
                p.calcularCusto();
            }
        });
    }

    public void removerFuncionario(Projeto p) {
        String funcionario = IO.readln("Digite o nome do funcionário que desejar remover deste projeto");
        quadro.forEach(f -> {
            if (f.getNome().equalsIgnoreCase(funcionario)){
                p.removeFuncionario(f);
                p.calcularCusto();
            }
        });
    }



}
