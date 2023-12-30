package com.linkedlist.questions;

import java.util.Stack;

import com.linkedlist.Node;
import com.linkedlist.singly.SinglyLinkedList;

public class MiddleOfLinkedList {

	public static void main(String[] args) {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		linkedList.insertAtEnd(1);
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(3);
		linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(5);
		System.out.println("-----------------Printing the source LinkedList---------------------");
		linkedList.printList();

		System.out.println("Middle of LinkedList:BruteForce::->"+middleOfLinkedListBruteForce(linkedList.getHead()));
		System.out.println("Middle of LinkedList:Optimal::->"+middleOfLinkedListBruteForce(linkedList.getHead()));
		//reverseLinkedList(linkedList.getHead());
		
	}
	
	public static int middleOfLinkedListBruteForce(Node headNode) {
		Node currentNode = headNode;
		int size = 0;
		while(currentNode != null) {
			size++;
			currentNode = currentNode.getNext();
		}
		
		int position = 0;
		currentNode = headNode;
		while(currentNode != null) {			
			position++;
			if(position == size/2 + 1) {
				return currentNode.getData();
			}
			currentNode = currentNode.getNext();
		}
		return 0;
	}
	
	public static Integer middleOfLinkedListOptimal(Node headNode) {
		Node slowPtr = headNode;
		Node fastPtr = headNode;
		
		while (fastPtr != null && fastPtr.getNext() != null) {
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext().getNext();
		}
		return slowPtr.getData();		
	}

}
