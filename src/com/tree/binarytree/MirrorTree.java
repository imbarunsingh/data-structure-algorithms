package com.tree.binarytree;

import com.tree.common.Helper;
import com.tree.common.Node;

public class MirrorTree {
	public static void main(String[] args) {
		Node root1 = Helper.initBinaryTree();
		Node root2 = Helper.initBinaryTree();

		IsomorphicTree isomorphicTree = new IsomorphicTree();
		boolean isStructurallySame = isomorphicTree.isIsomorphic(root1, root2);
		System.out.println("Are both tree mirror of one another : " + isStructurallySame);

	}

}

class MirrorTreeImpl {

	public boolean isMirror(Node root1, Node root2) {
		if (root1 == null && root2 == null) {
			return true;
		}

		if (root1 == null || root2 == null) {
			return false;
		}

		return root1.getData().equals(root2.getData()) 
				&& isMirror(root1.getLeftChild(), root2.getRightChild())
				&& isMirror(root1.getRightChild(), root2.getLeftChild());
	}
}
