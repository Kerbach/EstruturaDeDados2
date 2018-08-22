/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula3;

import aula2.BinaryTree;
import aula2.Node;
import java.util.ArrayList;

/**
 *
 * @author wrkerber
 */
public class LevelSearch
{

    static BinaryTree tree = new BinaryTree("A");

    public static void main(String[] args)
    {

        BinaryTree tree = new BinaryTree("A");
        Node a = tree.getRoot();
        Node b = tree.addLeftChild(a, "B");
        Node c = tree.addRightChild(a, "C");
                 tree.addLeftChild(b, "D");
                 tree.addRightChild(b, "E");
                 tree.addLeftChild(c, "F");
                 tree.addRightChild(c, "G");
        //System.out.println("Level:");
        //level(a);
        // ----
//        Node a = tree.getRoot();
//        Node b = tree.addLeftChild(a, "*");
//        Node c = tree.addRightChild(a, "-");
//        Node d = tree.addLeftChild(b, "+");
//        Node e = tree.addRightChild(b, "5");
//        Node f = tree.addLeftChild(c, "8");
//        Node g = tree.addRightChild(c, "*");
//        tree.addLeftChild(d, "1");
//        tree.addRightChild(d, "4");
//        tree.addLeftChild(g, "3");
//        tree.addRightChild(g, "7");

        //vis1(a);
        mistery(a);
    }
    
    public static void mistery(Node n)
    {
        ArrayList<Node> stack = new ArrayList<Node>();
        stack.add(n);
        int old_level = tree.depth(n);
        while (stack.size() != 0)
        {
            n = stack.remove(stack.size() - 1);
            System.out.print(n.element + " ");
            if (tree.depth(n) != old_level)
            {
                System.out.println();
                old_level = tree.depth(n);
            }
            if (n.right != null)
            {
                stack.add(n.right);
            }
            if (n.left != null)
            {
                stack.add(n.left);
            }
        }
    }

    public static void level(Node n)
    {
        ArrayList<Node> queue = new ArrayList<Node>();

        //fila esta vazia, colocar referencia para raiz(n)
        queue.add(n);

        // fila está vazia? Faz algo, se nao estiver para
        while (queue.size() != 0)
        {

            // remove o elemente, e os outros passam 1 posicao para esquerda
            n = queue.remove(0);
            System.out.println(n.element); // que estou tirando da fila
            if (n.left != null)
            {          // testa se ele tem um filho a esquerda, se tiver adiciona na fila.
                queue.add(n.left);
            }
            if (n.right != null)
            {
                queue.add(n.right);        // testa se ele tem um filho a esquerda, se tiver adiciona na fila.
            }

            // volta pro inicio, e verifica se tem alguem na fila.
        }

    }

    public static void vis1(Node n)
    {
        ArrayList<Node> queue = new ArrayList<Node>();
        queue.add(n);
        while (queue.size() != 0)
        {
            n = queue.remove(0);
            for (int i = 0; i < tree.depth(n); i++)
            {
                System.out.print(" ");
            }
            System.out.println(n.element);
            if (n.left != null)
            {
                queue.add(n.left);
            }
            if (n.right != null)
            {
                queue.add(n.right);
            }
        }
    }

    public static void vis2(Node n)
    {
        ArrayList<Node> queue = new ArrayList<Node>();
        queue.add(n);
        int old_level = tree.depth(n);
        while (queue.size() != 0)
        {
            n = queue.remove(0);
            if (tree.depth(n) != old_level)
            {
                System.out.println();
                old_level = tree.depth(n);
            }
            System.out.print(n.element + " ");
            if (n.left != null)
            {
                queue.add(n.left);
            }
            if (n.right != null)
            {
                queue.add(n.right);
            }
        }
    }
}
