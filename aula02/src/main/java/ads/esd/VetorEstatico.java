package ads.esd;

public class VetorEstatico {
    private String[] elementos;
    private int tamanho;
    public VetorEstatico(int quantidade){
       elementos = new String[quantidade];

    }

    public void inserir(int indice, String valor){
        if (indice < 0 || indice > elementos.length) {
            System.out.println("Valor inválido!!!!");
            return;
        }

        for (int i = tamanho; i > indice; i--) {
            elementos[i] = elementos[i-1];
        }

        elementos[indice] = valor;
    }

    public String imprimir(){
        StringBuilder sb = new StringBuilder("[");
        for (String elemento : this.elementos) {
            sb.append(elemento);
        }
        sb.append("]").append("\n");
        return sb.toString();
    }

}
