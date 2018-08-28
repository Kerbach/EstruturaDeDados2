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
	public static void inorder(Node n)
	{
		// 1. left
		if (n.left != null) { inorder(n.left); }
		// 2. node
		System.out.println(n.element);
		// 3. right
		if (n.right != null) { inorder(n.right); }
	}

	public static void main(String[] args)
	{
		BinarySearchTree bst = new BinarySearchTree("8");

		bst.insert("4");
		bst.insert("13");
		bst.insert("3");
		bst.insert("6");
		bst.insert("20");
		bst.insert("14");
		bst.insert("5");

		inorder(bst.getRoot());
	}
}

