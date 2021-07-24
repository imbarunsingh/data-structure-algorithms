package com.tree.bst;

import com.tree.Helper;
import com.tree.Node;

public class LowestCommonAncestor {
	public static void main(String[] args) {
		Node rootNode = Helper.initBinarySearchTree();

		// Two nodes whose LCA has to be found
		int node1 = 30, node2 = 70;

		while (rootNode != null) {
			int rootNodeData = (Integer) rootNode.getData();

			if (node1 < rootNodeData && node2 < rootNodeData) {//Both being less than root node
				rootNode = rootNode.getLeftChild();
			} else if (node1 > rootNodeData && node2 > rootNodeData) {//Both being greater than root node
				rootNode = rootNode.getRightChild();
			} else { // When one is less and other being greater than the root node
				break;
			}
		}

		System.out.println("Lowest Common Ancestor between node1 and node2 is : " + rootNode.getData());

	}

}
