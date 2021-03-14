package com.linkedlist.circular;

public class Demo {
	public static void main(String[] args) {
		
		CircularLinkedList circularLinkedList = new CircularLinkedList();
		
		circularLinkedList.insertAtEnd(1);
		circularLinkedList.insertAtEnd(2);
		circularLinkedList.insertAtEnd(3);
		
		//Asserting the insertAtEnd function
		System.out.println("--Asserting the insertAtEnd method--");
		circularLinkedList.displayList();
		
		System.out.println("--Asserting the insertAtBegining method--");
		circularLinkedList.insertAtBegining(4);				
		circularLinkedList.displayList();
		
		int index = 2;
		System.out.println("--Asserting the insertAfter method--after index->"+index);
		circularLinkedList.insertAfter(index, 555);				
		circularLinkedList.displayList();
		
		System.out.println("--Asserting the deleteFromEnd method--");
		circularLinkedList.deleteFromEnd();
		circularLinkedList.displayList();
		
		System.out.println("--Asserting the deleteFromBegining method--");
		circularLinkedList.deleteFromBegining();
		circularLinkedList.displayList();
		
		System.out.println("--Asserting the deleteNodeAtIndex method--");
		circularLinkedList.deleteNodeAtIndex(1);
		circularLinkedList.displayList();
	}
}
