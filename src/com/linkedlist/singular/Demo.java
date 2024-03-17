package com.linkedlist.singular;

public class Demo {
	public static void main(String[] args) {

		SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

		// Asserting the insertAtEnd function
		System.out.println("--Asserting the insertAtEnd method--");
		singlyLinkedList.insertAtEnd(1);
		singlyLinkedList.insertAtEnd(2);
		singlyLinkedList.insertAtEnd(3);
		singlyLinkedList.printList();
		System.out.println("----------------------------------------------------");

		System.out.println("--Asserting the insertAtBegining method--");
		singlyLinkedList.insertAtBegining(4);
		singlyLinkedList.printList();
		System.out.println("----------------------------------------------------");
		
		int index = 1;
		System.out.println("--Asserting the insertAfter method--after index->"+index);
		singlyLinkedList.insertAfter(index, 555);				
		singlyLinkedList.printList();
		System.out.println("----------------------------------------------------");

		System.out.println("--Asserting the deleteFromEnd method--");
		singlyLinkedList.deleteFromEnd();
		singlyLinkedList.printList();
		System.out.println("----------------------------------------------------");

		System.out.println("--Asserting the deleteFromBegining method--");
		singlyLinkedList.deleteFromBegining();
		singlyLinkedList.printList();
		System.out.println("----------------------------------------------------");
		
		System.out.println("--Asserting the deleteNodeAtIndex ->1 method--");
		singlyLinkedList.deleteNodeAtIndex(1);
		singlyLinkedList.printList();
		System.out.println("----------------------------------------------------");
		

		System.out.println("--Asserting the clearList method--");
		singlyLinkedList.clearList();
		singlyLinkedList.printList();
		System.out.println("----------------------------------------------------");
		
	}

}
