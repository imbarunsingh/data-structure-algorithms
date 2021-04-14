package com.tree.bst;

import com.tree.Helper;
import com.tree.Node;

public class InsertElement {
	public static void main(String[] args) {
		Node root = Helper.initBinarySearchTree();

		System.out.println("Before insertion : ");
		Helper.printBinaryTree(root);

		Node newNode = new Node(52);

		Node currentNode = root;
		while (null != currentNode) {

			if ((Integer) newNode.getData() > (Integer) currentNode.getData()) {
				if (currentNode.getRightChild() == null) {
					currentNode.setRightChild(newNode);
					break;
				}
				currentNode = currentNode.getRightChild();
			} else {
				if (currentNode.getLeftChild() == null) {
					currentNode.setLeftChild(newNode);
					break;
				}
				currentNode = currentNode.getLeftChild();
			}

		}
		System.out.println("After insertion : ");
		Helper.printBinaryTree(root);

	}

}
