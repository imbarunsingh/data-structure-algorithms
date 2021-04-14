package com.tree.generictree;

import java.util.LinkedList;
import java.util.Queue;

import com.tree.Helper;

public class NumberOfSiblingsOfaNode {
	public static void main(String[] args) {
		TreeNode root = Helper.initGenericTree();
		Helper.printGenericTree(root);
		
		NumberOfSiblings numberOfSiblings = new NumberOfSiblings();
		System.out.println("Number of siblings of a specific node :: " + numberOfSiblings.findSiblingsCount(root, 30));

	}

}

class NumberOfSiblings {
	public Integer findSiblingsCount(TreeNode root, int targetNode) {
		int count = 0;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode tempNode = queue.remove();                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      

			if (null != tempNode) {
				TreeNode currentNode = tempNode.getFirstChild();

				while (null != currentNode) {
					if (targetNode == (Integer)tempNode.getData()) {
						count++;
					} else {
						queue.add(currentNode);
					}
					currentNode = currentNode.getNextSiblings();
				}
				
				if (targetNode == (Integer)tempNode.getData()) {
					break;
				}

			}
		}
		return count;
	}
}
