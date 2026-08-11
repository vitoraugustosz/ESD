package ads.esd;

public class VetorDinamico {
    private int tamanho;
    private String[] elementos;

    public VetorDinamico(){
        this.elementos = new String[4 ];
        this.tamanho = 0;
    }

    private void expandir(){
        String[] novo = new String[elementos.length*2];
        for (int i = 0; i < elementos.length; i++){

        }
    }

    public void inserir(String elemento) {
        if (tamanho < elementos.length) {
            elementos[tamanho] = elemento;
            tamanho++;
        } else {
            System.out.println("Vetor ta cheio!!");
        }

    }

    private void reduzir(){
        if (tamanho <= elementos.length/4) {
            String[] novo = new String[elementos.length/2];
            for (int i = 0; i < tamanho; i++) {
                novo[i] = elementos[i];
            }
            elementos = novo;
        }

    }

    public void remover(int indice){
        if (indice < 0 || indice >= tamanho) {
            throw new IndexOutOfBoundsException("Índice inválido");
        }

        for (int i = indice; i < tamanho; i++) {
            elementos[i] = elementos[i+1];

        }
        elementos[tamanho-1] = null; // acessa o último valor, não acessado e deixa nulo
        tamanho--; // atualiza valor do tamanho
        reduzir();
    }

    public void imprimir() {
        System.out.print("[");
        for (int i = 0; i < elementos.length ; i++) {
            System.out.print(elementos[i]);
            if (i < elementos.length -1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");




    }
}
