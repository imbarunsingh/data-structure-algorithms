package com.tree.binarytree;

import com.tree.common.Helper;
import com.tree.common.Node;

import java.util.LinkedList;
import java.util.Queue;

public class DeleteSpecificNode {
	public static void main(String[] args) {
		Node rootNode = Helper.initBinaryTree();

		System.out.println("Original tree before deletion : ");
		Helper.printBinaryTree(rootNode);

		DeleteSpecificNodeImpl deleteSpecificNodeImpl = new DeleteSpecificNodeImpl();
		deleteSpecificNodeImpl.deleteNode(rootNode, 3);

		System.out.println("Tree after deletion of a node : ");
		Helper.printBinaryTree(rootNode);
	}

}

class DeleteSpecificNodeImpl {

	public void deleteNode(Node root, Object key) {
		if (root == null) {
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		Node deepestNode = null;
		Node nodeToBeDeletedNode = null;

		while (!queue.isEmpty()) {
			deepestNode = queue.remove();
			if (deepestNode != null) {
				if (deepestNode.getData().equals(key)) {
					nodeToBeDeletedNode = deepestNode;
				}

				if (deepestNode.getLeftChild() != null) {
					queue.add(deepestNode.getLeftChild());
				}

				if (deepestNode.getRightChild() != null) {
					queue.add(deepestNode.getRightChild());
				}
			}
		}
		Object tempObject = nodeToBeDeletedNode.getData();
		nodeToBeDeletedNode.setData(deepestNode.getData());

		deleteDeepestNode(root, deepestNode);

	}

	// Function to delete deepest element in binary tree
	public void deleteDeepestNode(Node root, Node delNode) {
		if (null == root || delNode == root) {
			return;
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);

		Node tempNode = null;
		while (!queue.isEmpty()) {
			tempNode = queue.remove();

			if (tempNode != null) {
				if (tempNode.getLeftChild() != null) {
					if (delNode.equals(tempNode.getLeftChild())) {
						tempNode.setLeftChild(null);
					} else {
						queue.add(tempNode.getLeftChild());
					}

				}
				if (tempNode.getRightChild() != null) {
					if (delNode.equals(tempNode.getRightChild())) {
						tempNode.setRightChild(null);
					} else {
						queue.add(tempNode.getRightChild());
					}
				}
			}

		}
	}
}
