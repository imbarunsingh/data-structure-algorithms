package com.tree.binarytree;

import com.tree.common.Helper;
import com.tree.common.Node;

public class IsomorphicOrStructurallyIdentical {
	public static void main(String[] args) {
		Node root1 = Helper.initBinaryTree();
		Node root2 = Helper.initBinaryTree();

		IsomorphicTree isomorphicTree = new IsomorphicTree();
		boolean isStructurallySame = isomorphicTree.isIsomorphic(root1, root2);
		System.out.println("Are both tree structuarally identical : " + isStructurallySame);

	}

}

class IsomorphicTree {

	public boolean isIsomorphic(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}

		if (root1 == null || root2 == null) {
			return false;
		}

		return isIsomorphic(root1.getLeftChild(), root2.getLeftChild())
				&& isIsomorphic(root1.getRightChild(), root2.getRightChild());
	}
}
