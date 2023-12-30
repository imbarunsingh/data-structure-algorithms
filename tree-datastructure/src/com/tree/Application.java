package com.tree;

public class Application {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BinarySearchTree tree = new BinarySearchTree();
							
		tree.insertRecord(50);
		tree.insertRecord(40);
		tree.insertRecord(98);
		tree.insertRecord(20);
		tree.insertRecord(55);
		
		tree.displayBinarySearchTree();
		
		System.out.println("---------Get min & max---------");
		
		System.out.println(tree.findMinimum().getData());
		System.out.println(tree.findMaximum().getData());
		
		System.out.println("-----Remove node from tree-----");
		System.out.println(tree.remove(20));
		
		System.out.println("--------Level Order tree display--------");
		tree.displayBinarySearchTree();
		
		
	}

}
