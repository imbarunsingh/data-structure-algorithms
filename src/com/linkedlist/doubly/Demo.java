package com.linkedlist.doubly;

public class Demo {
	public static void main(String[] args) {

		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

		doublyLinkedList.insertAtEnd(1);
		doublyLinkedList.insertAtEnd(2);
		doublyLinkedList.insertAtEnd(3);

		// Asserting the insertAtEnd function
		System.out.println("--Asserting the insertAtEnd method--");
		doublyLinkedList.printList();
		System.out.println("----------------------------------------------------");

		System.out.println("--Asserting the insertAtBegining method--");
		doublyLinkedList.insertAtBegining(4);
		doublyLinkedList.printList();
		System.out.println("----------------------------------------------------");

		int index = 2;
		System.out.println("--Asserting the insertAfter method--after index->" + index);
		doublyLinkedList.insertAfter(index, 555);
		doublyLinkedList.printList();
		System.out.println("----------------------------------------------------");

		System.out.println("--Asserting the deleteFromEnd method--");
		doublyLinkedList.deleteFromEnd();
		doublyLinkedList.printList();
		System.out.println("----------------------------------------------------");

		System.out.println("--Asserting the deleteFromBegining method--");
		doublyLinkedList.deleteFromBegining();
		doublyLinkedList.printList();
		System.out.println("----------------------------------------------------");

		System.out.println("--Asserting the deleteNodeAtIndex method--after index->" + index);
		doublyLinkedList.deleteNodeAtIndex(1);
		doublyLinkedList.printList();
		System.out.println("----------------------------------------------------");

		System.out.println("--Asserting the clearList method--");
		doublyLinkedList.clearList();
		doublyLinkedList.printList();
		System.out.println("----------------------------------------------------");

	}
}