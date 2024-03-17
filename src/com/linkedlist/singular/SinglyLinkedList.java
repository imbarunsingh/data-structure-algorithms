package com.linkedlist.singular;

import com.linkedlist.common.Node;

import java.util.NoSuchElementException;

public class SinglyLinkedList {

	// First & last node in the linked list
	private Node head, tail;

	private int size;

	public SinglyLinkedList() {
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void insertAtBegining(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			head = tail = newNode;// Only one node
		} else {
			newNode.setNext(head);
			head = newNode; // Making the new node as the head/first
		}
		size++;
	}

	public void insertAtEnd(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			head = tail = newNode; // Only one node
		} else {
			tail.setNext(newNode);
			tail = newNode; // making the new node to be the tail/last node in the list
		}
		size++;
	}

	// Inserts a new node with data after index(array way of index starting with
	// zero)
	public void insertAfter(int index, int data) {
		Node newNode = new Node(data);

		if (isEmpty()) {
			head = tail = newNode;
		} else if (index < 0) {
			insertAtBegining(data);
			return;
		} else if (index >= size - 1) {
			insertAtEnd(data);
			return;
		} else {
			Node currentNode = head;
			int counter = 0;
			while (currentNode != null) {
				if (counter == index) {
					newNode.setNext(currentNode.getNext());
					currentNode.setNext(newNode);
					break;
				}
				currentNode = currentNode.getNext();
				counter++;
			}
		}
		size++;
	}

	public Node deleteFromBegining() {
		Node temp = head;
		if (isEmpty()) {
			throw new NoSuchElementException("Linked List is Empty, Nothing to delete.");
		} else if (size == 1) {// one element in the list
			head = tail = null;
		} else {
			head = head.getNext();
			temp.setNext(null);
		}
		size--;
		return temp;
	}

	public Node deleteFromEnd() {
		Node deletedNode = tail;
		if (isEmpty()) {
			throw new NoSuchElementException("Linked List is Empty, Nothing to delete.");
		} else if (head.getNext() == null) { // one element in the list
			deletedNode = head;
			head = tail = null;
		} else { // More than one element in the list
			Node currentNode = head;
			while (currentNode != null) {
				if (currentNode.getNext() == tail) {
					currentNode.setNext(null);
					tail = currentNode;
					break;
				}
				currentNode = currentNode.getNext();
			}
		}
		size--;
		return deletedNode;
	}

	// Deletes a linked list node at specific index(starts from 0 like Array)
	public Node deleteNodeAtIndex(int index) {
		Node deletedNode = null;

		if (isEmpty()) {
			throw new NoSuchElementException("Linked List is Empty, Nothing to delete.");
		} else if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException(String.valueOf(index));
		} else if (index == size - 1) {
			return deleteFromEnd();
		} else if (index == 0) {
			return deleteFromBegining();
		}

		Node temp = head;
		int counter = 0;
		while (temp != null) {
			if (counter + 1 == index) {
				deletedNode = temp.getNext();
				temp.setNext(temp.getNext().getNext());				
				break;
			}
			temp = temp.getNext();
			counter++;
		}
		size--;
		return deletedNode;
	}

	public void printList() {
		if (isEmpty()) {
			System.out.println("[]"); // Empty List
			return;
		}
		Node currentNode = head;
		while (currentNode != null) {
			System.out.println(currentNode);
			currentNode = currentNode.getNext();
		}
	}

	public void clearList() {
		Node currentNode = head;
		while (currentNode != null) {
			Node prevNode = currentNode;
			currentNode = currentNode.getNext();
			prevNode = null;
		}
		head = tail = null;
		size = 0;
	}

	public int getSize() {
		return size;
	}

	public Node getHead() {
		return head;
	}

	public Node getTail() {
		return tail;
	}
}
