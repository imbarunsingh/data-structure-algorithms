package com.tree.bst;

import com.tree.Helper;
import com.tree.Node;

public class KthSmallestAndLargest {
	public static void main(String[] args) {
		Node rootNode = Helper.initBinarySearchTree();

		System.out.println("The source tree : ");
		Helper.printBinaryTree(rootNode);
		
		int k = 3;
		KthSmallestAndLargestImpl impl = new KthSmallestAndLargestImpl();
		Node found = impl.findKthSmallest(rootNode, k, 0);
		System.out.println(k + "th smallest element :: " + found.getData());
		
		//kth largest = (n-k)+1 smallest
	}

}

class KthSmallestAndLargestImpl {
	
	public Node findKthSmallest(Node root, int k, int count) {
		//base condition
		if(root == null) {
			return null;
		}
		Node left = findKthSmallest(root.getLeftChild(), k, count);
		if(left != null) {
			return left;
		}		
		if(++count == k) {
			return root;
		}
		return findKthSmallest(root.getRightChild(), k, count);
		
	}
	
}
