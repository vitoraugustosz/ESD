package ads.esd;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {

    static void main() {


        Lista a = new Lista(10);

        Contato u1 = new Contato("Pedro", "48996283081");
        Contato u2 = new Contato("Carlos", "48991453081");
        Contato u3 = new Contato("Matheus", "48978983081");
        Contato u4 = new Contato("Roberto", "34089763250238675");


        Contato[] b = new Contato[2];
        b[0] = u2;
        b[1] = u3;
        a.adicionarContato(u1);
        a.adicionarContato(u4);

        a.adicionarContatos(b);

        System.out.println(a.list());

    }
}
