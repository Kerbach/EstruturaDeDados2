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
public class SvgTree
{
    static BinaryTree tree = new BinaryTree("A");  
    
    public static void main(String[] args)
    {
        Node a = tree.getRoot();
        Node b = tree.addLeftChild(a, "B");
        Node d = tree.addLeftChild(b, "C");
        Node e = tree.addRightChild(b, "D");
        
        svg_start();
        svg(a, 200, 30);
        svg_finish();
    }
    
    public static void svg_start()
    {
        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>");
        System.out.println("<svg xmlns=\"http://www.w3.org/2000/svg\" version=\"1.1\" width=\"400\" height=\"400\">");
        System.out.println();
        
        System.out.println("  <style type=\"text/css\">");
        System.out.println("    .label { font: normal 24px sans-serif; stroke-width: 0; fill: black }");
        System.out.println("  </style>");
        System.out.println();
        
        System.out.println("  <g stroke=\"black\" stroke-width=\"2\">");
        System.out.println("    <circle cx=\"0\"   cy=\"0\"   r=\"20\" fill=\"red\" />");
        System.out.println("    <circle cx=\"400\" cy=\"0\"   r=\"20\" fill=\"green\" />");
        System.out.println("    <circle cx=\"0\"   cy=\"400\" r=\"20\" fill=\"blue\" />");
        System.out.println("    <circle cx=\"400\" cy=\"400\" r=\"20\" fill=\"yellow\" />");
        System.out.println();
    }
    
    public static void svg(Node n, int x, int y)
    {
        System.out.println("<circle cx=\""+x+"\" cy=\""+y+"\" r=\"20\" fill=\"#55cccc\" />");
        if (n.left != null)
        {
            int leftX = x - 40;
            int leftY = y + 60;
            svg(n.left, leftX, leftY);
        }
        if (n.right != null)
        {
            int leftX = x + 40;
            int leftY = y + 60;
            svg(n.right, leftX, leftY);
        }
    }
    
    public static void svg_finish()
    {
        System.out.println("  </g>");
        System.out.println("</svg>");
    }
}
