package com.tree.binarytree;

import com.tree.Helper;
import com.tree.Node;

//refer Babar youtube video

public class DiameterOfBinaryTree {
	public static void main(String[] args) {
		Node root1 = Helper.initBinaryTree();

		DiameterOfBinaryTreeProcess process = new DiameterOfBinaryTreeProcess();
		int diameter = process.diameter(root1);
		System.out.println("Diameter of the tree : " + diameter);
		
		System.out.println("Diameter of the tree in Optimal Way : " + process.diameterOptimal(root1, new Height()));

	}

}

class Height {
	int h;
}

class DiameterOfBinaryTreeProcess {

	//Time : O(n*n)
	public int diameter(Node root) {
		if (root == null) {
			return 0;
		}

		int lDiameter = diameter(root.getLeftChild());
		int rDiameter = diameter(root.getRightChild());
		
		int height = height(root.getLeftChild()) + height(root.getRightChild()) + 1;

		int diameter = Math.max(height, Math.max(lDiameter, rDiameter));
		return diameter;
	}
	
	//Time : O(n)
	public int diameterOptimal(Node root, Height height) {
		if (root == null) {
			height.h = 0;
			return 0;
		}
		Height lHeight = new Height();
		Height rHeight = new Height();

		int lDiameter = diameterOptimal(root.getLeftChild(), lHeight);
		int rDiameter = diameterOptimal(root.getRightChild(), rHeight);
		
		// Height of current node is max of heights of left
        // and right subtrees plus 1
		height.h = Math.max(lHeight.h, rHeight.h) + 1;

		int diameter = Math.max(lHeight.h + rHeight.h + 1, Math.max(lDiameter, rDiameter));
		return diameter;
	}
	
	public int height(Node root) {
		if (root == null) {
			return 0;
		}
		int lh = height(root.getLeftChild());
		int rh = height(root.getRightChild());
		
		return Math.max(lh, rh) + 1;
	}
}
