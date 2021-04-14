package com.tree.bst;

import com.tree.Helper;
import com.tree.Node;

public class DeleteAnElement {
	public static void main(String[] args) {
		Node root = Helper.initBinarySearchTree();

		if (null == root) {
			System.out.println("Empty Tree !");
			return;
		}
		
		System.out.println("Before deletion : "); 
		Helper.printBinaryTree(root);		

		DeleteAnElementImpl deleteAnElementImpl = new DeleteAnElementImpl();
		int elementToDelete = 60;
		deleteAnElementImpl.deleteElement(root, elementToDelete);
		
		System.out.println("After deletion : "); 
		Helper.printBinaryTree(root);

	}

}

class DeleteAnElementImpl {

	Node parentToNodeBeingDeleted = null;

	public void deleteElement(Node root, Object delNodeData) {
		
		Node nodeToBeDeleted = findElement(root, delNodeData);
		
		if(null == nodeToBeDeleted) {
			System.out.println("Node not found for deletion");
			return;
		}

		boolean isLeftChild = parentToNodeBeingDeleted.getLeftChild().getData().equals(delNodeData);

		// case 1 : Check if it is a leaf node that is being deleted
		if (nodeToBeDeleted.getLeftChild() == null && nodeToBeDeleted.getRightChild() == null) {
			if (isLeftChild) {
				parentToNodeBeingDeleted.setLeftChild(null);
			} else {
				parentToNodeBeingDeleted.setRightChild(null);
			}
			nodeToBeDeleted = null;
			return;
		}

		// case 2: check if node being deleted has only one child
		if (nodeToBeDeleted.getLeftChild() != null && nodeToBeDeleted.getRightChild() == null) {
			parentToNodeBeingDeleted.setLeftChild(nodeToBeDeleted.getLeftChild());
			nodeToBeDeleted = null;
			return;
		}
		if (nodeToBeDeleted.getRightChild() != null && nodeToBeDeleted.getLeftChild() == null) {
			parentToNodeBeingDeleted.setRightChild(nodeToBeDeleted.getRightChild());
			nodeToBeDeleted = null;
			return;
		}

		// Case 3 : if the node being deleted has two children
		Node successorNode = findSuccessorNode(nodeToBeDeleted);
		nodeToBeDeleted.setData(successorNode.getData());
		removeSuccessorNode(nodeToBeDeleted, successorNode);

	}

	private void removeSuccessorNode(Node nodeToBeDeleted, Node successorNode) {
		Node currentNode = nodeToBeDeleted;
		while(currentNode.getRightChild() != successorNode) {
			currentNode = currentNode.getRightChild();
		}
		currentNode.setRightChild(null);
		
	}

	// Basically find the smallest element in the right subtree to node being deleted
	private Node findSuccessorNode(Node nodeToBeDeleted) {
		Node currNode = nodeToBeDeleted.getRightChild();
		while (currNode.getLeftChild() != null) {
			currNode = currNode.getLeftChild();
		}
		return currNode;
	}

	public Node findElement(Node root, Object searchElemnt) {
		Node currentNode = root;
		while (currentNode != null) {
			if (searchElemnt.equals(currentNode.getData())) {
				break;
			}
			parentToNodeBeingDeleted = currentNode;
			if ((Integer) searchElemnt > (Integer) currentNode.getData()) {
				currentNode = currentNode.getRightChild();
			} else {
				currentNode = currentNode.getLeftChild();
			}
		}
		return currentNode;
	}
}