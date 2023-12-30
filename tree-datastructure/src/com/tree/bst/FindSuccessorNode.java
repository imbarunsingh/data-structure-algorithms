package com.tree.bst;

import com.tree.Helper;
import com.tree.Node;

//Successor node is basically the smallest element in the right subtree to a node
public class FindSuccessorNode {
	public static void main(String[] args) {
		Node root = Helper.initBinarySearchTree();

		if (null == root) {
			System.out.println("Empty Tree !");
			return;
		}
		
		Node currentNode = root.getRightChild();
		while(currentNode.getLeftChild() != null) {
			currentNode = currentNode.getLeftChild();
		}
		
		System.out.println("The successor node to the root node here is : " + currentNode.getData());		
		
	}

}
