package com.tree.generictree;

import com.tree.common.Helper;

import java.util.LinkedList;
import java.util.Queue;

/*
Time Complexity: O(n)
Space Complexity : O(n), queue storage
*/                                           
public class SumOfAllElements {
	public static void main(String[] args) {
		TreeNode root = Helper.initGenericTree();
		Helper.printGenericTree(root);

		int sum = 0;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode tempNode = queue.remove();

			if (null != tempNode) {
				sum = sum + (Integer) tempNode.getData();
				TreeNode currentNode = tempNode.getFirstChild();
				while (null != currentNode) {
					queue.add(currentNode);
					currentNode = currentNode.getNextSiblings();
				}
			}
		}

		System.out.println("Sum of all elements of this generic tree : " + sum);
	}

}
