package com.linkedlist.questions;

import com.linkedlist.common.Node;
import com.linkedlist.singular.SinglyLinkedList;

public class InsertInSortedList {

	public static void main(String[] args) {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		linkedList.insertAtEnd(10);
		linkedList.insertAtEnd(20);
		linkedList.insertAtEnd(30);
		linkedList.insertAtEnd(40);
		linkedList.insertAtEnd(50);
		System.out.println("-----------------Printing the source LinkedList---------------------");
		linkedList.printList();
		
		System.out.println("-----------------Printing the source LinkedList---------------------");
		insertNode(linkedList.getHead(), 35);
		linkedList.printList();
		

	}
	
	public static void insertNode(Node headNode, int data) {
		Node newNode = new Node(data);
		Node currentNode = headNode;
		
		while(currentNode != null && currentNode.getNext() != null) {
			if(data >= currentNode.getData() && data <= currentNode.getNext().getData()) {
				newNode.setNext(currentNode.getNext());
				currentNode.setNext(newNode);
				break;
			}
			currentNode = currentNode.getNext();			
		}
	}

}
