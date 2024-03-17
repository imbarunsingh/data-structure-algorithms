package com.tree.binarytree;

import com.tree.common.Helper;
import com.tree.common.Node;

//Using Depth First Traversal
public class MinimumDepth {
	public static void main(String[] args) {
		Node rootNode = Helper.initBinaryTree();

		MinimumDepthImpl minimumDepthImpl = new MinimumDepthImpl();
		System.out.println("Minimum depth of the Tree: " + minimumDepthImpl.minimumDepth(rootNode));
	}

}

class MinimumDepthImpl {
	public int minimumDepth(Node root) {
		if (root == null) {
			return 0;
		}
		// Base case : Leaf Node. This accounts for height = 1.
        if (root.getLeftChild() == null && root.getRightChild() == null) {
        	return 1;
        }
        
        if(root.getLeftChild() == null) {
        	return 1 + minimumDepth(root.getRightChild());
        }
        
        if(root.getRightChild() == null) {
        	return 1 + minimumDepth(root.getLeftChild());
        }          

		int leftDepth = minimumDepth(root.getLeftChild());
		int rightDepth = minimumDepth(root.getRightChild());

		return Math.min(leftDepth, rightDepth) + 1;
	}
}
