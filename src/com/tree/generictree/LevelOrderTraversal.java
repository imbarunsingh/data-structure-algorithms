package com.tree.generictree;

import com.tree.common.Helper;

import java.util.LinkedList;
import java.util.Queue;

/*
  Time Complexity: O(n)
  Space Complexity : O(n), queue storage
 */
public class LevelOrderTraversal {
	public static void main(String[] args) {
		TreeNode root = Helper.initGenericTree();
		Helper.printGenericTree(root);

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode tempNode = queue.remove();

			System.out.print(tempNode.getData() + " ");

			if (null != tempNode) {
				TreeNode currentNode = tempNode.getFirstChild();
				while (null != currentNode) {
					queue.add(currentNode);
					currentNode = currentNode.getNextSiblings();
				}
			}
		}
	}

}
