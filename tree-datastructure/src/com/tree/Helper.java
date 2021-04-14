package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.tree.generictree.TreeNode;

public class Helper {

	public static Node initBinaryTree() {
		Node rootNode = new Node(1);

		Node rightSubtreeNode = new Node(3);
		rightSubtreeNode.setLeftChild(new Node(6));
		rightSubtreeNode.setRightChild(new Node(7));

		Node leftSubtreeNode = new Node(2);
		leftSubtreeNode.setLeftChild(new Node(4));
		leftSubtreeNode.setRightChild(new Node(5));

		rootNode.setLeftChild(leftSubtreeNode);
		rootNode.setRightChild(rightSubtreeNode);

		return rootNode;
	}

	// Level Order traversal display
	public static void printBinaryTree(Node rootNode) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(rootNode);

		List<Object> resList = new ArrayList<>();

		while (!queue.isEmpty()) {
			Node tempNode = queue.remove();

			if (null != tempNode) {
				resList.add(tempNode.getData());

				if (null != tempNode.getLeftChild()) {
					queue.add(tempNode.getLeftChild());
				}
				if (null != tempNode.getRightChild()) {
					queue.add(tempNode.getRightChild());
				}
			}
		}
		System.out.println(resList);
	}

	public static TreeNode initGenericTree() {
		TreeNode root = new TreeNode(10);

		TreeNode child1 = new TreeNode(20);
		TreeNode child2 = new TreeNode(30);
		TreeNode child3 = new TreeNode(40);
		TreeNode child4 = new TreeNode(50);
		TreeNode child5 = new TreeNode(60);

		child1.setNextSiblings(child2);
		child2.setNextSiblings(child3);

		child2.setFirstChild(child4);
		child4.setNextSiblings(child5);

		root.setFirstChild(child1);

		return root;
	}

	// Level Order Traversal
	public static void printGenericTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		List<Object> resList = new ArrayList<>();

		while (!queue.isEmpty()) {
			TreeNode tempNode = queue.remove();

			if (null != tempNode) {
				resList.add(tempNode.getData());

				TreeNode currentNode = tempNode.getFirstChild();
				while (null != currentNode) {
					queue.add(currentNode);
					currentNode = currentNode.getNextSiblings();
				}
			}
		}
		System.out.println(resList);
	}
	
	public static Node initBinarySearchTree() {
		Node rootNode = new Node(50);

		Node rightSubtreeNode = new Node(60);
		rightSubtreeNode.setLeftChild(new Node(55));
		rightSubtreeNode.setRightChild(new Node(70));

		Node leftSubtreeNode = new Node(40);
		leftSubtreeNode.setLeftChild(new Node(30));
		leftSubtreeNode.setRightChild(new Node(45));

		rootNode.setLeftChild(leftSubtreeNode);
		rootNode.setRightChild(rightSubtreeNode);

		return rootNode;
	}

}
