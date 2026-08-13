package ads.esd.vetor.Testes;

import ads.esd.vetor.Caixa;

public class ex9 {

    static void main() {
        Caixa<String> caixaDeTexto = new Caixa<>();

        caixaDeTexto.guardar("OI");
        System.out.println(caixaDeTexto.abrir());
    }
}
