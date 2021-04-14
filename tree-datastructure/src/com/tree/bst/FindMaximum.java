package com.tree.bst;

import com.tree.Helper;
import com.tree.Node;

public class FindMaximum {
	public static void main(String[] args) {
		Node root = Helper.initBinarySearchTree();
		
		if (null == root) {
			System.out.println("Empty Tree !");
			return;
		}
		
		while(root.getRightChild() != null) {
			root = root.getRightChild();
		}
		
		System.out.println("Maximum element in the BST : " + root.getData());
		
	}

}

