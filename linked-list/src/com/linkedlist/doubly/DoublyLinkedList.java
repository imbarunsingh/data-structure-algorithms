package com.linkedlist.doubly;

import java.util.NoSuchElementException;

import com.linkedlist.EmptyLinkedListException;

public class DoublyLinkedList {

	private DLLNode head, tail; // First & last node in the linked list

	private int size;

	public DoublyLinkedList() {
		super();
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void insertAtBegining(int data) {
		DLLNode newNode = new DLLNode(data);
		if (isEmpty()) {
			head = tail = newNode;// Only one node
		} else {
			head.setPrevious(newNode);
			newNode.setNext(head);
			head = newNode; // Making the new node as the head/first
		}
		size++;
	}

	public void insertAtEnd(int data) {
		DLLNode newNode = new DLLNode(data);
		if (isEmpty()) {
			head = tail = newNode; // Only one node
		} else {
			tail.setNext(newNode);
			newNode.setPrevious(tail);
			tail = newNode; // Making the newly added node as the tail node
		}
		size++;
	}

	// Inserts a new node with data after index(array Index)
	public void insertAfter(int index, int data) {
		DLLNode newNode = new DLLNode(data);
		if (isEmpty()) {
			head = tail = newNode;
		} else if (index < 0) {
			insertAtBegining(data);
			return;
		} else if (index >= size - 1) {
			insertAtEnd(data);
			return;
		} else {
			DLLNode currentNode = head;
			DLLNode nextNode = null;
			int counter = 0;
			while (currentNode != null) {
				if (counter == index) { // because array index from 0
					nextNode = currentNode.getNext();
					break;
				}
				counter++;
				currentNode = currentNode.getNext();
			}
			currentNode.setNext(newNode);
			newNode.setPrevious(currentNode);
			newNode.setNext(nextNode);
			nextNode.setPrevious(newNode);			
		}
		size++;
	}

	// Deletes a linked list node at specific index
	public DLLNode deleteNodeAtIndex(int index) {
		DLLNode deletedNode = null;
		if (isEmpty()) {
			throw new EmptyLinkedListException("The Linkedlist is empty::");
		} else if (index < 0 || index > size - 1) {
			throw new IndexOutOfBoundsException(String.valueOf(index));
		} else if (index == size - 1) {
			return deleteFromEnd();
		} else if (index == 0) {
			return deleteFromBegining();
		}
		DLLNode currentNode = head;
		int traversedIndex = 0;
		while (currentNode != null) {
			if (traversedIndex == index) {
				currentNode.getPrevious().setNext(currentNode.getNext()); //pointing the prev node to current node to current node next
				currentNode.getNext().getPrevious().getPrevious().setNext(currentNode.getNext()); // pointing the next node to current node to rev of current node
				
				currentNode.setNext(null);
				currentNode.setPrevious(null);
				deletedNode = currentNode; // Making ready for GC
				
				break;
			}
			traversedIndex++;
			currentNode = currentNode.getNext();
		}
		size--;
		return deletedNode;
	}

	public DLLNode deleteFromBegining() {
		DLLNode temp = head;
		if (isEmpty()) {
			throw new NoSuchElementException("Linked List is Empty, Nothing to delete.");
		} else if (size == 1) {
			head = tail = null;
		} else {
			head = head.getNext();			
			temp.setNext(null);
		}
		size--;
		return temp;
	}

	public DLLNode deleteFromEnd() {
		DLLNode deletedNode = tail;
		if (isEmpty()) {
			throw new NoSuchElementException("Linked List is Empty, Nothing to delete.");
		} else if (size == 1) { // one element in the list
			head = tail = null;
		} else { // More than one element in the list
			tail.getPrevious().setNext(null); // second last node points to null
			tail.setPrevious(null); // last node previous points to null . Needed to de-link
			tail = tail.getPrevious(); // Now second last node becomes the last node.
		}
		size--;
		return deletedNode;
	}

	public void printList() {
		if (isEmpty()) {
			System.out.println("[]"); // Empty List
			return;
		}
		DLLNode currentNode = head;
		while (currentNode != null) {
			System.out.println(currentNode);
			currentNode = currentNode.getNext();
		}
	}

	// Gets the list length from a specific node
	public int getListLengthFromSpecificNode(DLLNode node) {
		int length = 0;
		while (null != node) {
			length++;
			node = node.getNext();
		}
		return length;
	}

	// Gets the list length
	public int getListLength() {
		int length = 0;
		if (isEmpty()) {
			return length;
		}
		DLLNode currentNode = head;
		while (null != currentNode) {
			length++;
			currentNode = currentNode.getNext();
		}
		return length;
	}
	
	public void clearList() {
		if(isEmpty()) {
			return;
		}
		DLLNode currentNode = head;
		while (currentNode != null) {
			DLLNode prevNode = currentNode;
			currentNode = currentNode.getNext();
			prevNode = null;
		}
		head = tail = null;
		size = 0;		
	}
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
}