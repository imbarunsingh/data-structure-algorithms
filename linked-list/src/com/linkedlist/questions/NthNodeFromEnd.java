package com.linkedlist.questions;

import com.linkedlist.EmptyLinkedListException;
import com.linkedlist.Node;
import com.linkedlist.singly.SinglyLinkedList;

class NthNodeFromEndImpl {

	public static int getNthNodeFromEnd(int n, SinglyLinkedList linkedList) {

		if (linkedList.isEmpty()) {
			throw new EmptyLinkedListException("Empty Linked List.");
		}

		// (size - n + 1)th node from beginning is that node
		int nthNodeFromBegining = linkedList.getSize() - n + 1;

		Node currNode = linkedList.getHead();
		int counter = 0;
		while (currNode != null) {
			if (counter == nthNodeFromBegining - 1) { // working with 0 as base index
				break;
			}
			counter++;
			currNode = currNode.getNext();
		}
		return currNode.getData();
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

		int nthNodeFromEnd = NthNodeFromEndImpl.getNthNodeFromEnd(4, linkedList);
		System.out.println("Nth node from End : " + nthNodeFromEnd);
	}
}
