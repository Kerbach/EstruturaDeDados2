/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula3;

import aula2.Node;

/**
 *
 * @author wrkerber
 */
public class TestBinarySearchTree
{
    public static void inorder (Node n)
    {
        // 1. LEFT
        if (n.left != null)
        {
            inorder(n.left);
        }
        // 2. NODE
        System.out.println(n.element);
        // 3. RIGHT
        if (n.right != null)
        {
            inorder(n.right);
        }
    }
    
//    public static void main(String[] args)
//    {
//        BinarySearchTree bst = new BinarySearchTree();
////        System.out.println(bst.contains("4"));
////        System.out.println(bst.contains("1"));
////        System.out.println(bst.contains("7"));
////        System.out.println(bst.contains("14"));
////        System.out.println(bst.contains("6"));
//        
//        //bst.insert("5");
//        System.out.println(bst.contains("5"));
//        
//        inorder(bst.getRoot());
//    }
    
    public static void main(String[] args)
    {
        int i, n = 1000;
        long start;
        
        ArrayList<Integer> array = new ArrayList<Integer>();
        
        for (int = 0; i < n; i++)
        {
            array.add((int)(Math.random() * n))
        }
    }
}
