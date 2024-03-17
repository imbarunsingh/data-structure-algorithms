package com.tree.binarytree;

import com.tree.common.Helper;
import com.tree.common.Node;

public class LowestCommonAncestor {
	
	public static void main(String[] args) {
		Node rootNode = Helper.initBinaryTree();
		System.out.println("The source binary tree : ");
		Helper.printBinaryTree(rootNode);

		// Two nodes whose LCA has to be found
		Node node1 = new Node(4);
		Node node2 = new Node(5);
		
		LowestCommonAncestorSolution lcaSolution = new LowestCommonAncestorSolution();
		Node lcaNode = lcaSolution.lowestCommonAncestor(rootNode, node1, node2);
		System.out.println("The Lowest common ancestor is : "+ lcaNode);
	}
	

}

class LowestCommonAncestorSolution {
	
	public Node lowestCommonAncestor(Node root, Node p, Node q) {
		if(null == root || p == root || q == root) {
			return root;
		}
		
		Node leftNode = lowestCommonAncestor(root.getLeftChild(), p, q);
		Node rightNode = lowestCommonAncestor(root.getRightChild(), p, q);
		
		if(leftNode != null && rightNode != null) {
			return root;
		}
		
		return leftNode != null ? leftNode : rightNode;
	}
}
