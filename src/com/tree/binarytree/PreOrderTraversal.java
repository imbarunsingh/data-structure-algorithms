package com.tree.binarytree;

import com.tree.common.Helper;
import com.tree.common.Node;

// Root Left Right
public class PreOrderTraversal {

	public static void main(String[] args) {
		Node rooNode = Helper.initBinaryTree();
		PreOrderTraversalProcessor preOrderTraversalProcessor = new PreOrderTraversalProcessor();
		preOrderTraversalProcessor.preOrder(rooNode);
	}

}

class PreOrderTraversalProcessor {

	public void preOrder(Node node) {
		if (null == node) {
			return;
		}
		System.out.print(node.getData() + " ");
		preOrder(node.getLeftChild());
		preOrder(node.getRightChild());
	}

}
