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

	public BinarySearchTree(String s)
	{
		this.tree = new BinaryTree(s);
	}

	public Node getRoot()
	{
		return this.tree.getRoot();
	}






















	public void insert(String s) {
		Node n = this.tree.getRoot();
		while (true) {
			if (n.element.equals(s)) {
				break;
			}
			if (Double.parseDouble(s) <
					Double.parseDouble(n.element)) {
				// LEFT SIDE
				if (n.left != null) {
					n = n.left;
				}
				else {
					this.tree.addLeftChild(n, s);
					break;
				}
			}
			else {
				// RIGHT SIDE
				if (n.right != null) {
					n = n.right;
				}
				else {
					this.tree.addRightChild(n, s);
					break;
				}
			}
		}
	}

	public boolean contains(String s)
	{
		Node n = this.tree.getRoot();
		while (n != null) {
			if (n.element.equals(s)) {
				return true;
			}
			if (Double.parseDouble(s) <
					Double.parseDouble(n.element)) {
				n = n.left;
			}
			else {
				n = n.right;
			}
		}
		return false;
	}
}


























