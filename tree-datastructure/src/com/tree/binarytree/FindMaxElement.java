package com.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import com.tree.Helper;
import com.tree.Node;

public class FindMaxElement {
	public static void main(String[] args) {
		Node rootNode = Helper.initBinaryTree();

		FindMaxElementImpl findMaxElementImpl = new FindMaxElementImpl();
		System.out.println("Maximumk element in the Tree: " + findMaxElementImpl.findMaxElement(rootNode));

	}
}

class FindMaxElementImpl {

	public Integer findMaxElement(Node rootNode) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(rootNode);

		Integer maxElement = Integer.MIN_VALUE;

		while (!queue.isEmpty()) {
			Node tempNode = (Node) queue.remove();

			if (null != tempNode) {
				if ((Integer) tempNode.getData() > maxElement) {
					maxElement = (Integer) tempNode.getData();
				}

				if (null != tempNode.getLeftChild()) {
					queue.add(tempNode.getLeftChild());
				}
				if (null != tempNode.getRightChild()) {
					queue.add(tempNode.getRightChild());
				}

			}
		}
		return maxElement;
	}
}
