package com.linkedlist.questions;

import java.util.Stack;

import com.linkedlist.Node;
import com.linkedlist.singly.SinglyLinkedList;

public class ReverseLinkedList {

	public static void main(String[] args) {
		SinglyLinkedList linkedList = new SinglyLinkedList();
		linkedList.insertAtEnd(1);
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(3);
		linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(5);
		System.out.println("-----------------Printing the source LinkedList---------------------");
		linkedList.printList();

		System.out.println("-----------------Printing the Reversed Linked---------------------");
		//reverseLinkedList(linkedList.getHead());
		reverseLinkedListBruteForce(linkedList.getHead());
		
	}
	
	public static void reverseLinkedListBruteForce(Node headNode) {
		Stack<Node> stack = new Stack<Node>();
		Node currentNode = headNode;

		while(currentNode != null) {
			stack.push(currentNode);
			currentNode = currentNode.getNext();
		}
		Node newHead = null;
		while(stack.isEmpty()) {
			if(newHead == null) {
				currentNode = newHead = stack.pop();
			} else {
				currentNode.setNext(stack.pop());
				currentNode = currentNode.getNext();
			}			
		}
		currentNode = newHead;
		while (currentNode != null) {
			System.out.println(currentNode);
			currentNode = currentNode.getNext();			
		}		
	}
	
	public static void reverseLinkedList(Node headNode) {
		Node currentNode = headNode;
		Node prevNode = null;
		Node nextNode = null;
		
		while (currentNode != null) {
			nextNode = currentNode.getNext();
			currentNode.setNext(prevNode);
			prevNode = currentNode;
			currentNode = nextNode;
		}
		currentNode = prevNode;
		while (currentNode != null) {
			System.out.println(currentNode);
			currentNode = currentNode.getNext();
		}
	}

}
