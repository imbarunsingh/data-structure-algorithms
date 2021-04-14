package com.tree.bst;

import com.tree.Helper;
import com.tree.Node;

public class FindMinimum {
	public static void main(String[] args) {
		Node root = Helper.initBinarySearchTree();
		
		if (null == root) {
			System.out.println("Empty Tree !");
			return;
		}
		
		while(root.getLeftChild() != null) {
			root = root.getLeftChild();
		}
		
		System.out.println("Minimum element in the BST : " + root.getData());
		
	}

}

