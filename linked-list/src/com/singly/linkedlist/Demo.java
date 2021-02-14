package com.singly.linkedlist;

public class Demo {
	public static void main(String[] args) {

		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

		singlyLinkedList.insertAtEnd(1);
		singlyLinkedList.insertAtEnd(2);
		singlyLinkedList.insertAtEnd(3);

		// Asserting the insertAtEnd function
		System.out.println("--Asserting the insertAtEnd method--");
		singlyLinkedList.displayList();

		System.out.println("--Asserting the insertAtBegining method--");
		singlyLinkedList.insertAtBegining(4);
		singlyLinkedList.displayList();
		
		int index = 1;
		System.out.println("--Asserting the insertAfter method--after index->"+index);
		singlyLinkedList.insertAfter(index, 555);				
		singlyLinkedList.displayList();

		System.out.println("--Asserting the deleteFromEnd method--");
		singlyLinkedList.deleteFromEnd();
		singlyLinkedList.displayList();

		System.out.println("--Asserting the deleteFromBegining method--");
		singlyLinkedList.deleteFromBegining();
		singlyLinkedList.displayList();
		
		System.out.println("--Asserting the deleteNodeAtIndex method--");
		singlyLinkedList.deleteNodeAtIndex(1);
		singlyLinkedList.displayList();
	}

}
