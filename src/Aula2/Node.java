/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula2;

/**
 *
 * @author gustavo.miorando
 */
public class Node {
    
    // 3 referencias e um elemento.
    // se nao inicializar, fica nulo.
    public Node parent;
    public Node left;
    public Node right;
    public String element;
    
    // construtor
    public Node(String s){
        this.element = s;
    }
           
    public String toString(){
        return this.element;
    }
    
    // testa se ele eh o primeiro(raiz)
    // se nao tiver o ponteiro "pra cima" ele é a raiz.
    public boolean isRoot(){
        return this.parent == null;
    }
    
    // eh um nodo sem filhos ? se a direita e a esqueda for nulo, ele nao tem filhos.
    public boolean isExternal(){
        return this.left == null && this.right == null;
    }
    
    // eh interno se tem pelo menos um filho.
    // chama o extorno, porque se nao for externo, automaticamente ele é interno.
    public boolean  isInternal(){
        return ! isExternal();
    } 
    
}
