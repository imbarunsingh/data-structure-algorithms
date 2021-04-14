package com.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import com.tree.Helper;
import com.tree.Node;

public class DeepestNode {
	public static void main(String[] args) {
		Node rootNode = Helper.initBinaryTree();

		DeepestNodeImpl deepestNodeImpl = new DeepestNodeImpl();
		System.out.println("The deepest node in the tree : " + deepestNodeImpl.findDeepestNode(rootNode));
	}
}

class DeepestNodeImpl {

	// The last traversed node in Level order traversal
	public Node findDeepestNode(Node root) {
		if (null == root) {
			return null;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		Node tempNode = null;
		while (!queue.isEmpty()) {
			tempNode = queue.remove();

			if (tempNode != null) {
				if (tempNode.getLeftChild() != null) {
					queue.add(tempNode.getLeftChild());
				}
				if (tempNode.getRightChild() != null) {
					queue.add(tempNode.getRightChild());
				}
			}

		}
		return tempNode;
	}
}
