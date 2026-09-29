package ads.esd;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
        Servidor meuServidor = new Servidor(2,200,40);
        System.out.println(meuServidor.toString());
    }
}
