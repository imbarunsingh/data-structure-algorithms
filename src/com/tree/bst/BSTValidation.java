package com.tree.bst;

import com.tree.common.Helper;
import com.tree.common.Node;

public class BSTValidation {
	public static void main(String[] args) {
		Node rootNode = Helper.initBinarySearchTree();

		System.out.println("The source tree : ");
		Helper.printBinaryTree(rootNode);

		// Solution 1 : BSTValidationRangeSolution
		BSTValidationRangeSolution rangeSolution = new BSTValidationRangeSolution();
		boolean isBinaryTree = rangeSolution.isBinarySearchTree(rootNode, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println("The source tree is binary tree : " + isBinaryTree);
		System.out.println("-----------------------");

		// Solution 2 : BSTValidationInorderTraversalSolution
		BSTValidationInorderTraversalSolution inorderTraversalSolution = new BSTValidationInorderTraversalSolution();
		boolean isBST = inorderTraversalSolution.isBST(rootNode);
		System.out.println("The source tree is binary tree: " + isBST);

	}

}

class BSTValidationRangeSolution {

	public boolean isBinarySearchTree(Node root, int min, int max) {
		if (root == null) {
			return true;
		}
		int data = (Integer) root.getData();		
		
		if(data > min && data < max) {
			boolean left = isBinarySearchTree(root.getLeftChild(), min, data);
			boolean right = isBinarySearchTree(root.getRightChild(), max, data);
			return left && right;
		} else {
			return false;
		}
	}
}

class BSTValidationInorderTraversalSolution {

	public int prev = Integer.MIN_VALUE;

	public boolean isBST(Node root) {
		
		if (root == null) {
			return true;
		}
		if (!isBST(root.getLeftChild())) {
			return false;
		}
		if ((Integer) root.getData() <= prev) {
			return false;
		}
		prev = (Integer) root.getData();
		return isBST(root.getRightChild());
	}

}
