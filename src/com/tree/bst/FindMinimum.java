package com.tree.bst;

import com.tree.common.Helper;
import com.tree.common.Node;

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

