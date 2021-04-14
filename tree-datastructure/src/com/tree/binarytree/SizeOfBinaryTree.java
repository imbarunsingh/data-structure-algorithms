package com.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import com.tree.Helper;
import com.tree.Node;

public class SizeOfBinaryTree {
	public static void main(String[] args) {
		Node rootNode = Helper.initBinaryTree();

		SizeOfBinaryTreeImpl sizeOfBinaryTreeImpl = new SizeOfBinaryTreeImpl();
		System.out.println("Total element/size of the Tree: " + sizeOfBinaryTreeImpl.sizeOfTree(rootNode));
	}

}

class SizeOfBinaryTreeImpl {

	public Integer sizeOfTree(Node rootNode) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(rootNode);

		Integer size = 0;

		while (!queue.isEmpty()) {
			Node tempNode = (Node) queue.remove();
			size++;

			if (null != tempNode) {

				if (null != tempNode.getLeftChild()) {
					queue.add(tempNode.getLeftChild());
				}
				if (null != tempNode.getRightChild()) {
					queue.add(tempNode.getRightChild());
				}

			}
		}
		return size;
	}
}
