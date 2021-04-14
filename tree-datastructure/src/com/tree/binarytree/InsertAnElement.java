package com.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import com.tree.Helper;
import com.tree.Node;

public class InsertAnElement {
	public static void main(String[] args) {
		Node rootNode = Helper.initBinaryTree();

		System.out.print("Original Tree : ");
		Helper.printBinaryTree(rootNode);

		InsertAnElementImpl insertAnElementImpl = new InsertAnElementImpl();
		insertAnElementImpl.insertAnElement(rootNode, 8);

		System.out.print("Modified Tree : ");
		Helper.printBinaryTree(rootNode);

	}

}

class InsertAnElementImpl {

	public void insertAnElement(Node rootNode, Object elementToBeInserted) {
		Node newNode = new Node(elementToBeInserted);

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(rootNode);

		while (!queue.isEmpty()) {
			Node tempNode = (Node) queue.remove();

			if (null != tempNode) {

				if (null == tempNode.getLeftChild()) {
					tempNode.setLeftChild(newNode);
					return;
				} else if (null == tempNode.getRightChild()) {
					tempNode.setRightChild(newNode);
					return;
				}

				if (null != tempNode.getLeftChild()) {
					queue.add(tempNode.getLeftChild());
				}
				if (null != tempNode.getRightChild()) {
					queue.add(tempNode.getRightChild());
				}
			}
		}
	}

}
