package com.tree.binarytree;

import com.tree.common.Helper;
import com.tree.common.Node;

//Using Depth First Traversal
public class HeightOrMaxDepth {
	public static void main(String[] args) {
		Node rootNode = Helper.initBinaryTree();

		HeightOfBinaryTreeImpl heightOfBinaryTreeImpl = new HeightOfBinaryTreeImpl();
		System.out.println("Height of the Tree: " + heightOfBinaryTreeImpl.maxDepth(rootNode));
	}

}

class HeightOfBinaryTreeImpl {

	public Integer maxDepth(Node root) {
		// Root being null means tree doesn't exist.
		if (root == null) {
			return 0;
		}

		// Get the depth of the left and right subtree using recursion.
		int leftDepth = maxDepth(root.getLeftChild());
		int rightDepth = maxDepth(root.getRightChild());

		// Choose the larger one and add the root to it.		
		return Math.max(leftDepth, rightDepth) + 1;
	}
}
