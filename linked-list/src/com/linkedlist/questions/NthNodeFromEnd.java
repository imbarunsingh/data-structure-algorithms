package com.linkedlist.questions;

import com.linkedlist.EmptyLinkedListException;
import com.linkedlist.Node;
import com.linkedlist.singly.SinglyLinkedList;

class NthNodeFromEndImpl {

	// Time Complexity : O(n) + O(n)
	public static int getNthNodeFromEndBruteForce(int n, SinglyLinkedList linkedList) {

		if (linkedList.isEmpty()) {
			throw new EmptyLinkedListException("Empty Linked List.");
		}
		Node currentNode = linkedList.getHead();
		int size = 0;
		while (currentNode != null) {
			currentNode = currentNode.getNext();
			size++;
		}

		// (size - n + 1)th node from beginning is that node
		int nthNodeFromBegining = size - n + 1;

		currentNode = linkedList.getHead();
		int counter = 0;
		while (currentNode != null) {
			counter++;
			if (counter == nthNodeFromBegining) { // working with 1 as base index
				break;
			}
			currentNode = currentNode.getNext();
		}
		return currentNode.getData();
	}
	//Better since requires less iteration
	public static Object getNthNodeFromEndOptimized(int n, SinglyLinkedList linkedList) {
		if (linkedList.isEmpty()) {
			throw new EmptyLinkedListException("Empty Linked List.");
		}
		Node firstPointer = linkedList.getHead();
		Node secondPointer = linkedList.getHead();

		int counter = 0;
		//Till reaches Nth node from begining
		while(counter != n) {
			counter++;
			firstPointer = firstPointer.getNext();
		}

		while (firstPointer != null) {
			firstPointer = firstPointer.getNext();
			secondPointer = secondPointer.getNext();
		}
		return secondPointer.getData();
	}
}

public class NthNodeFromEnd {
	public static void main(String[] args) {
		SinglyLinkedList linkedList = new SinglyLinkedList();

		System.out.println("--Asserting the insertAtEnd method--");
		linkedList.insertAtEnd(1);
		linkedList.insertAtEnd(2);
		linkedList.insertAtEnd(3);
		linkedList.insertAtEnd(4);
		linkedList.insertAtEnd(5);
		linkedList.insertAtEnd(6);
		linkedList.printList();
		System.out.println("----------------------------------------------------");

		int n = 2;
		System.out.println(n + "th node from END->BruteForce : " + NthNodeFromEndImpl.getNthNodeFromEndBruteForce(n, linkedList));
		
		System.out.println(n + "th node from END->Optimal : " + NthNodeFromEndImpl.getNthNodeFromEndOptimized(n, linkedList));
	}
}
