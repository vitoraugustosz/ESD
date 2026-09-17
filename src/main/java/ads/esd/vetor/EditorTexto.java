package ads.esd.vetor;

import ads.esd.vetor.Stack;

public class EditorTexto {


    private Stack<String> undo;
    private Stack<String> redo;
    private String conteudo;

    public EditorTexto() {
        this.undo = new Stack<>(20);
        this.redo = new Stack<>(20);
        this.conteudo = "";
    }

    public void escrever(String texto){
        undo.push(texto);
        conteudo += texto;
    }

    public void desfazer(){
        if(!undo.isEmpty()){
            redo.push(conteudo);
            conteudo = undo.pop();
        } else {
            System.out.println("Nada para DESFAZER");
        }
    }

    public String getConteudo() {
        String penis = conteudo;
        return penis;
    }

    public void refazer(){
        if(!redo.isEmpty()){
            undo.push(conteudo);
            conteudo = redo.pop();
        } else {
            System.out.println("Nada para REFAZER");
        }
    }
}