package com.tree.bst;

import com.tree.common.Helper;
import com.tree.common.Node;

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

