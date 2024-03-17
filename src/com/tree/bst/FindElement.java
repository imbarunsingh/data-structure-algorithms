package com.tree.bst;

import com.tree.common.Helper;
import com.tree.common.Node;

public class FindElement {
	public static void main(String[] args) {
		Node root = Helper.initBinarySearchTree();
		
		if ( null == root) {
			System.out.println("Empty Tree !");
			return;
		}
		
		FindElementImpl findElementImpl = new FindElementImpl();
		int elementToSearch = 20;
		System.out.println("Is this elemnt : " + elementToSearch + "is present in BST: "
				+ findElementImpl.findElement(root, elementToSearch));

	}

}

class FindElementImpl {

	public boolean findElement(Node root, Object searchElemnt) {
		if (root == null) {
			return false;
		}

		Node currentNode = root;
		while (currentNode != null) {

			if (searchElemnt.equals(currentNode.getData())) {
				return true;
			}

			if ((Integer) searchElemnt > (Integer) currentNode.getData()) {
				currentNode = currentNode.getRightChild();
			} else {
				currentNode = currentNode.getLeftChild();
			}
		}
		return false;
	}
}
