package com.tree.binarytree;

import com.tree.Helper;
import com.tree.Node;
// Left Right Root
public class PostOrderTraversal {

	public static void main(String[] args) {
		Node rooNode = Helper.initBinaryTree();
		PostOrderTraversalProcessor postOrderTraversalProcessor = new PostOrderTraversalProcessor();
		postOrderTraversalProcessor.postOrder(rooNode);
	}

}

class PostOrderTraversalProcessor {

	public void postOrder(Node node) {
		if (null == node) {
			return;
		}		
		postOrder(node.getLeftChild());
		postOrder(node.getRightChild());
		System.out.print(node.getData() + " ");
	}

}
