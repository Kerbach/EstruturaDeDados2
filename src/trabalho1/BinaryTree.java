/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho1;

import aula2.*;

/**
 *
 * @author gustavo.miorando
 */
public class BinaryTree
{
    // metodos para manutencao e criacao, automatizados.

    // referencia para a raiz;
    private Node root;

    // criando a raiz.
    public BinaryTree(String S)
    {
        Node n = new Node(S);
        this.root = n;
    }

    public Node getRoot()
    {
        return this.root;
    }

    // criar um novo Nodo
    // passar um nodo que ja esta na arvore (P) e uma string S, e cria a esquerda.
    public Node addLeftChild(Node p, String s)
    {

        // checa se o filho esquerdo do P, esta null antes de adicionalo
        if (p.left != null)
        {
            System.err.println("node has left child");
            return null;
        }
        Node n = new Node(s);
        n.parent = p;
        p.left = n;
        return n;
        // retorna o novo nodo criado.
    }

    // criar um novo Nodo
    // passar um nodo que ja esta na arvore (P) e uma string S, e cria a esquerda.
    public Node addRightChild(Node p, String s)
    {

        // checa se o filho direito do P, esta null antes de adicionalo
        if (p.right != null)
        {
            System.err.println("node has right child");
            return null;
        }
        Node n = new Node(s);
        n.parent = p;
        p.right = n;
        return n;
        // retorna o novo nodo criado.
    }

    // descobrir o nivel/profundidade do Node
    public int depth(Node n)
    {
        int c = 0;
        while (n.parent != null)
        {
            c++;
            n = n.parent;
        }
        return c;
    }

    public int height(Node n)
    {
        if (n.isExternal())
        {
            return 0;
        }
        int x = 0, y = 0;

        if (n.left != null)
        {
            x = height(n.left);
        }
        if (n.right != null)
        {
            y = height(n.right);
        }
        return Math.max(y, y) + 1;
    }

    public void print(Node n)
    {
        System.out.println(n);
        if (n.left != null)
        {
            print(n.left);
        }
        if (n.right != null)
        {
            print(n.right);
        }
    }
}
