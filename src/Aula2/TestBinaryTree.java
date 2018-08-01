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
public class TestBinaryTree {
    
    public static void main(String[] args){
        
        /*
        
        Iniciando manualmente
        
        // criando nodo inicial
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        
        // estabelecer a comunicao entre pai e filho.
        // A é o pai. B é o filho da esquerda
        a.left = b;
        b.parent = a;
        
        // liga B e D
        b.right = d;
        d.parent = b;
        
        // liga C e A
        a.right = c;
        d.parent = a;
        */
        
        BinaryTree tree = new BinaryTree("A");
        
        Node a = tree.getRoot();
        Node b = tree.addLeftChild(a, "B");
        Node c = tree.addrightChild(a, "C");
        
        // filho direito de B
        Node d = tree.addrightChild(b, "D");
        
        /*
        System.out.println(tree.depth(a));
        System.out.println(tree.depth(b));
        System.out.println(tree.depth(c));
        System.out.println(tree.depth(d)); */
        
        tree.print(a);
    }
    
}
