package com.tree.binarytree;

import com.tree.common.Helper;
import com.tree.common.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
	public static void main(String[] args) {
		Node rootNode = Helper.initBinaryTree();
		LevelOrderTraversalProcessor levelTraversal = new LevelOrderTraversalProcessor();
		levelTraversal.levelOrderTraversal(rootNode);

	}

}

class LevelOrderTraversalProcessor {

	public void levelOrderTraversal(Node rootNode) {

		List<Object> responseList = new ArrayList<>();

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(rootNode);

		while (!queue.isEmpty()) {
			Node node = (Node) queue.remove();

			responseList.add(node.getData());

			if (null != node) {
				if (null != node.getLeftChild()) {
					queue.add(node.getLeftChild());
				}
				if (null != node.getRightChild()) {
					queue.add(node.getRightChild());
				}
			}
		}

		queue.clear(); // clear the queue
		System.out.println(responseList);

	}
}
