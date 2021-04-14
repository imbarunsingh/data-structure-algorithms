package com.tree.bst;

import com.tree.Helper;
import com.tree.Node;

//PreDessessor Node is basically the largest element in the left subtree to a node
public class FindPreDessessorNode {
	public static void main(String[] args) {
		Node root = Helper.initBinarySearchTree();

		if (null == root) {
			System.out.println("Empty Tree !");
			return;
		}
		
		Node currentNode = root.getLeftChild();
		while(currentNode.getRightChild() != null) {
			currentNode = currentNode.getRightChild();
		}
		
		System.out.println("The successor node to the root node here is : " + currentNode.getData());
		
		
	}

}
