package com.doubly.linkedlist;

import com.linkedlist.util.EmptyLinkedListException;

public class DoublyLinkedList {
	
	private Node head, tail; // First & last node in the linked list

	public DoublyLinkedList() {
		super();		
	}

	public boolean isEmpty() {
		return head == null; // Can't use head.equals(null) since it gives NullPointer exception for an empty list
	}
	
	public boolean insertAtBegining(int data) {		
		Node newNode = new Node(data);		
		
		if(isEmpty()) {
			head = tail = newNode;//Only one node
			return true;
		}	
		newNode.setNext(head);
		head.setPrevious(newNode);		
		head = newNode; //Making the new node as the head/first
		return true;
	}		
	
	public boolean insertAtEnd(int data) {
		Node newNode = new Node(data);		
		
		if(isEmpty()) {
			head = tail = newNode; //Only one node
			return true;
		}	
		newNode.setPrevious(tail);
		tail.setNext(newNode);		
		tail = newNode; // Making the newly added noded as the tail node
		return true;
	}
	
	//Inserts a new node with data after index(array Index)
	public boolean insertAfter(int index, int data) {
		int listLength = getListLength();
		
		if(index > listLength - 1) {
			throw new ArrayIndexOutOfBoundsException(index);
		} else if(index == listLength - 1) {
			insertAtEnd(data);
			return true;
		}
		
		Node currentNode = head;
		Node nextNode = null;
		int length = 0;
		while (currentNode != null) {
			length++;			
			if(length - 1 == index) { // because array index from 0
				nextNode = currentNode.getNext();
				break;
			}
			currentNode = currentNode.getNext();
		}
		Node newNode = new Node(data);
		newNode.setNext(nextNode);
		newNode.setPrevious(currentNode);	
		
		currentNode.setNext(newNode);
		nextNode.setPrevious(newNode);
		return true;
	}
	
	//Deletes a linked list node at specific index
	public Node deleteNodeAtIndex(int index) {
		Node deletedNode = null;
		int listLength = getListLength();
		
		if(isEmpty()) {
			throw new EmptyLinkedListException("The Linkedlist is empty::");
		} else if(index < 0 || index > listLength - 1) {
			throw new IndexOutOfBoundsException(String.valueOf(index));
		} else if(index == listLength - 1) {
			return deleteFromEnd();		
		} else if(index == 0) {
			return deleteFromBegining();
		}
		
		Node currentNode = head;		
		int traversedIndex = 0;
		while(currentNode != null) {						
			if(traversedIndex == index) {
				currentNode.getPrevious().setNext(currentNode.getNext());
				currentNode = null; //Making ready for GC
				break;
			}
			traversedIndex++;			
			currentNode = currentNode.getNext();
		}				
		return deletedNode;
	}
	

	
	public Node deleteFromBegining() {
		if(isEmpty()) {
			System.out.println("Can't Delete since as this Linked List is Empty::");
			return null;
		}
		Node temp = head;
		head = head.getNext();	
		head.setPrevious(null);
		return temp;
	}
	
	public Node deleteFromEnd() {
		Node deletedNode = tail;
		if(isEmpty()) {
			System.out.println("Nothing to delete , since the Linked List is Empty!");
		} else if(head.getNext().equals(null)) { //one element in the list
			deletedNode = head;
			head = tail = null;
		} else { // More than one element in the list
			tail.getPrevious().setNext(null); // second last node points to null
			tail = tail.getPrevious(); // Now second last node becomes the last node.
		}	
		return deletedNode;
	}
	
	public void displayList() {		
		Node currentNode = head;
		if(isEmpty()) {
			System.out.println("Empty List, Nothing to Display!");
			return;
		}
		while(currentNode != null) {
			System.out.println(currentNode);
			currentNode = currentNode.getNext();			
		}
	}
	
	//Gets the list length from a specific node
	public int getListLengthFromSpecificNode(Node node) {
		int length = 0;
		while(null != node) {
			length++;
			node = node.getNext();			
		}
		return length;
	}	
	
	//Gets the list length from a specific node
	public int getListLength() {
		int length = 0;
		if(isEmpty()) {
			return length;			
		}		
		Node currentNode = head;
		while(null != currentNode) {
			length++;
			currentNode = currentNode.getNext();			
		}
		return length;
	}	
}