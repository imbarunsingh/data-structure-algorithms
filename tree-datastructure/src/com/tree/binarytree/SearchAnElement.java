package com.tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

import com.tree.Helper;
import com.tree.Node;

public class SearchAnElement {
	public static void main(String[] args) {
		Node rootNode = Helper.initBinaryTree();

		SearchAnElementImpl searchAnElementImpl = new SearchAnElementImpl();
		System.out.println("Is This Element found in the tree: " + searchAnElementImpl.searchAnElement(rootNode, 5));
	}

}

class SearchAnElementImpl {

	public boolean searchAnElement(Node rootNode, Object searchElement) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(rootNode);

		// Object maxElement = Integer.MIN_VALUE;

		while (!queue.isEmpty()) {
			Node tempNode = (Node) queue.remove();

			if (null != tempNode) {
				if (searchElement.equals(tempNode.getData())) {
					return true;
				}
				if (null != tempNode.getLeftChild()) {
					queue.add(tempNode.getLeftChild());
				}
				if (null != tempNode.getRightChild()) {
					queue.add(tempNode.getRightChild());
				}
			}
		}
		return false;
	}
}
