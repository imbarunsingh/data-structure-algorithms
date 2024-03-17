package com.tree.binarytree;

import com.tree.common.Helper;
import com.tree.common.Node;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderDataReversed {
	public static void main(String[] args) {
		Node rootNode = Helper.initBinaryTree();
		LevelOrderTraversalReversedProcessor levelOrderTraversalReversedProcessor = new LevelOrderTraversalReversedProcessor();
		levelOrderTraversalReversedProcessor.levelOrderReverseTraversal(rootNode);
	}

}

class LevelOrderTraversalReversedProcessor {

	public void levelOrderReverseTraversal(Node rootNode) {

		Stack<Object> stack = new Stack<Object>();

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(rootNode);

		while (!queue.isEmpty()) {
			Node node = (Node) queue.remove();

			stack.push(node.getData());

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
		//print the stack , will print the element in reverse order
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}

	}
}