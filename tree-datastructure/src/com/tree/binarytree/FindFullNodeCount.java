package com.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import com.tree.Helper;
import com.tree.Node;

//Node with either left or right child  as null are half nodes
public class FindFullNodeCount {
	public static void main(String[] args) {
		Node rootNode = Helper.initBinaryTree();
		int count = 0;

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(rootNode);

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

				if (tempNode.getLeftChild() != null && tempNode.getRightChild() != null) {
					count++;
				}
			}
		}

		System.out.println("Number of full nodes in the tree : " + count);

	}

}
