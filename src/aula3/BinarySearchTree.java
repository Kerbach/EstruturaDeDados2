/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula3;

import aula2.BinaryTree;
import aula2.Node;

/**
 *
 * @author wrkerber
 */
public class BinarySearchTree
{
    private BinaryTree tree;
    
    public BinarySearchTree()
    {
        this.tree = new BinaryTree("8");
        Node a = tree.getRoot();
        Node b = tree.addLeftChild(a, "4");
        Node c = tree.addRightChild(a, "13");
        Node d = tree.addRightChild(c, "20");
                 tree.addLeftChild(b, "3");
                 tree.addRightChild(b, "6");
                 tree.addLeftChild(d, "14");
    }
    
    public boolean contains(String s)
    {
        Node n = this.tree.getRoot();
        while (n != null)
        {
            if (n.element.equals(s))
            {
                return true;
            }
            if (Double.parseDouble(s) < Double.parseDouble(n.element))
            {
                n = n.left;
            }
            else
            {
                n = n.right;
            }
        }
        return false;
    }

    public void insert(String s)
    {
        Node n = this.tree.getRoot();
        while (n != null)
        {
            if (n.element.equals(s))
            {
                return;
            }
            if (Double.parseDouble(s) < Double.parseDouble(n.element))
            {
                if (n.left != null)
                {
                    n = n.left;
                }
                else
                {
                    this.tree.addLeftChild(n, s);
                    return;
                }
            }
            else
            {
                if (n.right != null)
                {
                    n = n.right;
                }
                else
                {
                    this.tree.addRightChild(n, s);
                    return;
                }
            }
        }
    }
    
    public Node getRoot()
    {
        return this.tree.getRoot();
    }
}
