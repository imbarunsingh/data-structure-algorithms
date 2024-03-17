package com.tree.common;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

	private Node root;

	public Boolean isEmpty() {
		return root == null;
	}

	public void insertRecord(Object key) {

		Node newNode = new Node(key);

		if (isEmpty()) {
			root = newNode;
			return;
		}

		Node current = root;
		Node parent;
		while (current != null) {
			parent = current; // To store the detail of the current node
			if ((Integer)key < (Integer)current.getData()) {
				current = current.getLeftChild();
				if (current == null) { // It's parent is the leaf node
					parent.setLeftChild(newNode);
				}
			} else {
				current = current.getRightChild();
				if (current == null) { // It's parent is the leaf node
					parent.setRightChild(newNode);
				}
			}
		}
	}

	public boolean remove(int key) {

		Node currentNode = root;
		Node parentNode = root;
		boolean isLeftChild = false;

		// Search the node with the key to delete
		while ((Integer)currentNode.getData() != (Integer)key) { // Comparing with the root node key
			parentNode = currentNode;

			if ((Integer)key < (Integer)currentNode.getData()) {
				currentNode = currentNode.getLeftChild();
				isLeftChild = true;
			} else {
				currentNode = currentNode.getRightChild();
				isLeftChild = false;
			}
			if (currentNode == null) { // Means the node with the key we are looking for in not there
				return false;
			}
		}

		Node nodeToDelete = currentNode;

		// if the node found is a leaf Node
		if (nodeToDelete.getLeftChild() == null && nodeToDelete.getRightChild() == null) {
			// if its the root node
			if (nodeToDelete == root) {
				root = null;
			}

			if (isLeftChild) {
				parentNode.setLeftChild(null);
			} else {
				parentNode.setRightChild(null);
			}
		} else if (nodeToDelete.getRightChild() == null) { // if node(one we are trying to delete) has one child on the
															// left
			if (nodeToDelete == root) {
				root = nodeToDelete.getLeftChild();
			} /*
				 * else if (isLeftChild) { parentNode.setLeftChild(nodeToDelete.getLeftChild());
				 * }
				 */ else {
				parentNode.setRightChild(nodeToDelete.getLeftChild());
			}
		} else if (nodeToDelete.getLeftChild() == null) { // if node(one we are trying to delete) has one child on the
															// right
			if (nodeToDelete == root) {
				root = nodeToDelete.getRightChild();
			} else if (isLeftChild) {
				parentNode.setLeftChild(nodeToDelete.getLeftChild());
			} /*
				 * else { parentNode.setRightChild(nodeToDelete.getRightChild()); }
				 */
		} else { // if node has two children
			Node succesorNode = getSuccessorNode(nodeToDelete);
			if (nodeToDelete == root) {
				root = succesorNode;
			} else if (isLeftChild) {
				parentNode.setLeftChild(succesorNode);
			} else {
				parentNode.setRightChild(succesorNode);
			}

			succesorNode.setLeftChild(nodeToDelete.getLeftChild());
			succesorNode.setRightChild(nodeToDelete.getRightChild());
		}

		return true;
	}

	private Node getSuccessorNode(Node nodeToDelete) { // Incomplete

		Node successorParent = nodeToDelete;
		Node successor = nodeToDelete;
		Node current = nodeToDelete.getRightChild();

		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.getLeftChild();
		}
		return null;
	}

	public Node findMinimum() {

		Node current = root;
		while (current.getLeftChild() != null) {			
			current = current.getLeftChild();
		}
		return current;
	}

	public Node findMaximum() {
		Node current = root;
		while (current.getRightChild() != null) {			
			current = current.getRightChild();
		}
		return current;
	}

	public void displayBinarySearchTree() {

		Queue<Node> bstQueue = new LinkedList<>();
		Node current = root;
		// Pushing root node into the queue.
		bstQueue.add(current);
		// Pushing delimiter into the queue.
		bstQueue.add(null);

		// Executing loop till queue becomes
		// empty
		while (!bstQueue.isEmpty()) {

			current = bstQueue.poll();

			// condition to check the
			// occurence of next level
			if (current == null) {
				if (!bstQueue.isEmpty()) {
					bstQueue.add(null);
				}
				System.out.println();
			} else {
				if (current.getLeftChild() != null) {
					bstQueue.add(current.getLeftChild());
				}
				if (current.getRightChild() != null) {
					bstQueue.add(current.getRightChild());
				}
				System.out.print(current.getData() + " ");
			}

		}

	}
}
