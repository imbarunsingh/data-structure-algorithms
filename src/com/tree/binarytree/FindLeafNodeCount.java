package com.tree.binarytree;

import com.tree.common.Helper;
import com.tree.common.Node;

import java.util.LinkedList;
import java.util.Queue;

// Node with left and right child as null are leaf nodes
public class FindLeafNodeCount {
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

				if (tempNode.getLeftChild() == null && tempNode.getRightChild() == null) {
					count++;
				}
			}
		}

		System.out.println("Number of leaf nodes in the tree : " + count);

	}

}
