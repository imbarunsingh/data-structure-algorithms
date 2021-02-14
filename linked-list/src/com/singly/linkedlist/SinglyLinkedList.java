package com.singly.linkedlist;

import com.linkedlist.util.EmptyLinkedListException;

public class SinglyLinkedList {
	
	private Node head, tail; // First & last node in the linked list

	public SinglyLinkedList() {
		super();		
	}

	public boolean isEmpty() {		
		return head == null;
	}
	
	public boolean insertAtBegining(int data) {		
		Node newNode = new Node(data);		
		
		if(isEmpty()) {			
			head = tail = newNode;//Only one node
			return true;
		}		
		newNode.setNext(head);
		head = newNode; //Making the new node as the head/first
		return true;
	}		
	
	public boolean insertAtEnd(int data) {
		Node newNode = new Node(data);		
		
		if(isEmpty()) {
			head = tail = newNode; //Only one node
			return true;
		}		
		tail.setNext(newNode);
		tail = newNode; // making the new node to be the tail/last node in the list
		return true;
	}
	
	//Inserts a new node with data after index(array Index)
	public boolean insertAfter(int index, int data) {
		int listLength = getListLength();
		
		if(isEmpty()) {
			throw new EmptyLinkedListException("The List is Empty");
		} else if(index < 0 || index > listLength - 1) {
			throw new IndexOutOfBoundsException(String.valueOf(index));
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
		currentNode.setNext(newNode);
		return true;
	}
	
	public Node deleteFromBegining() {
		if(isEmpty()) {
			throw new EmptyLinkedListException("Linked List is Empty, Nothing to delete");
		}
		Node temp = head;
		head = head.getNext();		
		return temp;
	}
	
	public Node deleteFromEnd() {
		Node deletedNode = tail;
		if(isEmpty()) {
			throw new EmptyLinkedListException("Linked List is Empty, Nothing to delete");
		} else if(head.getNext() == null) { //one element in the list
			deletedNode = head;
			head = tail = null;
		} else { // More than one element in the list
			Node currentNode = head;
			while(currentNode != null) {						
				if(currentNode.getNext() == tail) {
					currentNode.setNext(null);
					tail = currentNode;
					break;
				}		
				currentNode = currentNode.getNext();
			}	
		}	
		return deletedNode;
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
		Node nextNode = null, previousNode = null;
		
		int traversedIndex = 0;
		while(currentNode != null) {						
			if(traversedIndex == index) {
				nextNode = currentNode.getNext();
				deletedNode = currentNode;
				currentNode = null; //Making ready for GC, anyway local variables are null when the scope is done
				break;
			}
			traversedIndex++;
			previousNode = currentNode;
			currentNode = currentNode.getNext();
		}
		previousNode.setNext(nextNode);			
		return deletedNode;
	}
	
	public void displayList() {		
		Node currentNode = head;
		if(isEmpty()) {
			throw new EmptyLinkedListException("Linked List is Empty, Nothing to delete");			
		}
		while(currentNode != null) {
			System.out.println(currentNode);
			currentNode = currentNode.getNext();			
		}
	}
	
	//Gets the list length from a specific node
	public int getListLength(Node node) {
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
