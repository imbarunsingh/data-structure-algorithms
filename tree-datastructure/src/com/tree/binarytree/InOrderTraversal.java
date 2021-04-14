package com.tree.binarytree;

import com.tree.Helper;
import com.tree.Node;

//Left Root Right
public class InOrderTraversal {

	public static void main(String[] args) {
		Node rooNode = Helper.initBinaryTree();
		InorderTraversalProcessor inorderTraversalProcessor = new InorderTraversalProcessor();
		inorderTraversalProcessor.inOrder(rooNode);
	}

}

class InorderTraversalProcessor {

	public void inOrder(Node node) {
		if (null == node) {
			return;
		}
		inOrder(node.getLeftChild());
		System.out.print(node.getData() + " ");
		inOrder(node.getRightChild());
	}

}
