package com.doubly.linkedlist;

public class Demo {
	public static void main(String[] args) {
		
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
		
		doublyLinkedList.insertAtEnd(1);
		doublyLinkedList.insertAtEnd(2);
		doublyLinkedList.insertAtEnd(3);
		
		//Asserting the insertAtEnd function
		System.out.println("--Asserting the insertAtEnd method--");
		doublyLinkedList.displayList();
		
		System.out.println("--Asserting the insertAtBegining method--");
		doublyLinkedList.insertAtBegining(4);				
		doublyLinkedList.displayList();		
		
		int index = 2;
		System.out.println("--Asserting the insertAfter method--after index->"+index);
		doublyLinkedList.insertAfter(index, 555);				
		doublyLinkedList.displayList();
		
		System.out.println("--Asserting the deleteFromEnd method--");
		doublyLinkedList.deleteFromEnd();
		doublyLinkedList.displayList();
		
		System.out.println("--Asserting the deleteFromBegining method--");
		doublyLinkedList.deleteFromBegining();
		doublyLinkedList.displayList();
		
		System.out.println("--Asserting the deleteNodeAtIndex method--");
		doublyLinkedList.deleteNodeAtIndex(1);
		doublyLinkedList.displayList();
	}
}

