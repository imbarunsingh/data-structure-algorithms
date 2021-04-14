package com.tree.binarytree;

import com.tree.Helper;
import com.tree.Node;

public class SameBinaryTree {
	public static void main(String[] args) {
		Node root1 = Helper.initBinaryTree();
		Node root2 = Helper.initBinaryTree();

		SameTree sameTree = new SameTree();
		boolean isSameTree = sameTree.isSameTree(root1, root2);
		System.out.println("Are both tree same : " + isSameTree);

	}

}

class SameTree {

	public boolean isSameTree(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}

		if (root1 == null || root2 == null) {
			return false;
		}

		return root1.getData().equals(root2.getData()) 
				&& isSameTree(root1.getLeftChild(), root2.getLeftChild())
				&& isSameTree(root1.getRightChild(), root2.getRightChild());
	}
}
