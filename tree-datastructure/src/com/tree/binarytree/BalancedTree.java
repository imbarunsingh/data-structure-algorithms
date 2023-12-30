package com.tree.binarytree;

import com.tree.Helper;
import com.tree.Node;

public class BalancedTree {
	public static void main(String[] args) {
		Node root1 = Helper.initBinaryTree();
		
		BalancedTreeImpl impl = new BalancedTreeImpl();
		System.out.println("is the tree balanced :: " + impl.isBalanced(root1));
		
	}

}

class BalancedTreeImpl {
	
	//Time : O(n*n)
	public boolean isBalanced(Node node) {
		if(node == null) {
			return false;
		}
		
		boolean isLeftBalanced = isBalanced(node.getLeftChild());
		boolean isRightBalanced = isBalanced(node.getRightChild());
		
		boolean diff = Math.abs(height(node.getLeftChild()) - height(node.getRightChild())) <= 1;
		
		return isLeftBalanced && isRightBalanced && diff;		
	}
	
	// Optimal solution follows similar approach to Diameter of the binary tree
	
	public int height(Node node) {
		if(node == null) {
			return 0;
		}
		int leftHeight = height(node.getLeftChild());
		int rightHeight = height(node.getRightChild());
		
		return Math.max(leftHeight, rightHeight) + 1;
		
	}
}