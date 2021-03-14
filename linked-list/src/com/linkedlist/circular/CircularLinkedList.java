package com.linkedlist.circular;

import com.linkedlist.EmptyLinkedListException;
import com.linkedlist.Node;

public class CircularLinkedList {
	
	private Node head, tail; // First & last node in the linked list
	
	private int size;

	public CircularLinkedList() {
		super();		
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public void insertAtBegining(int data) {		
		Node newNode = new Node(data);		
		if(isEmpty()) {
			head = tail = newNode;//Only one node
		} else {
			newNode.setNext(head);
			head = newNode; //Making the new node as the head/first
			tail.setNext(head);
		}
		size++;
	}		
	
	public void insertAtEnd(int data) {
		Node newNode = new Node(data);			
		if(isEmpty()) {
			head = tail = newNode; //Only one node
		} else {
			tail.setNext(newNode);
			tail = newNode; // Making the newly added noded as the tail node
			tail.setNext(head);// Pointing back to the head node
		}
		size++;
	}
	
	//Inserts a new node with data after index(array Index)	
	public boolean insertAfter(int index, int data) {
		Node newNode = new Node(data);
		if(isEmpty()) {
			head = tail = newNode;
		}else if(index > size - 1) {
			throw new ArrayIndexOutOfBoundsException(index);
		} else if(index == size - 1) {
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
		
		newNode.setNext(nextNode);
		currentNode.setNext(newNode);
		return true;
	}
	
	public Node deleteFromBegining() {
		if(isEmpty()) {
			throw new EmptyLinkedListException("Can't Delete since the linked list is Empty::");
		}
		Node temp = head;
		head = head.getNext();	
		tail.setNext(head); // pointing the tail to the new head
		return temp;
	}
	
	public Node deleteFromEnd() {
		Node deletedNode = tail;
		if(isEmpty()) {
			throw new EmptyLinkedListException("Can't Delete since the linked list is Empty::");
		} else if(head.getNext().equals(null)) { //one element in the list
			deletedNode = head;
			head = tail = null;
		} else { // More than one element in the list
			Node currentNode = head;
			while(!currentNode.equals(null)) {						
				if(currentNode.getNext().equals(tail)) {
					currentNode.setNext(null);
					tail = currentNode;
					tail.setNext(head);
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
		
		int traversedIndex = -1;
		while(currentNode != null) {
			traversedIndex++;			
			if(traversedIndex == index) {
				nextNode = currentNode.getNext();
				deletedNode = currentNode;
				currentNode = null; //Making ready for GC
				break;
			}
			previousNode = currentNode;
			currentNode = currentNode.getNext();
		}
		previousNode.setNext(nextNode);			
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
			if(currentNode.equals(head)) { // Tail is pointing back to head				
				break;
			}
		}
	}
	
	//Gets the list length from a specific node
	public int getListLength(Node node) {
		int length = 0;
		while(null != node) {
			length++;
			if(node.equals(tail)) { //Tail is pointing back to head	
				break;
			}
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
			if(currentNode.equals(tail)) {
				break;			
			}
			currentNode = currentNode.getNext();				
		}
		return length;
	}	
}