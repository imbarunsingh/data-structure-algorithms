package com.linkedlist.questions;

import com.linkedlist.Node;
import com.linkedlist.singly.SinglyLinkedList;

public class PrintLinkedListInReverseOrder {

	public static void main(String[] args) {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		linkedList.insertAtEnd(1);
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(3);
		linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(5);
		System.out.println("-----------------Printing the source LinkedList---------------------");
		linkedList.printList();

		System.out.println("-----------------Printing the LinkedList in Reverse order---------------------");
		printReverse(linkedList.getHead());
		
	}
	
	public static void printReverse(Node currentNode) {
		if(currentNode == null) {
			return;
		}
		printReverse(currentNode.getNext());
		System.out.println(currentNode);		
	}

}
