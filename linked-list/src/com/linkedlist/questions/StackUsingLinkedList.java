package com.linkedlist.questions;

import java.util.EmptyStackException;

import com.linkedlist.Node;

class StackLinkedListImplementation {

	private Node head;

	private int size;

	public boolean isEmpty() {
		return size == 0;
	}

	private void insertAtBegining(int data) {
		Node newNode = new Node(data);
		if (isEmpty()) {
			head = newNode;
		} else {
			newNode.setNext(head);
			head = newNode;
		}
		size++;
	}

	private int deleteFromBegining() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		Node deletedNode = head;
		head = head.getNext();
		size--;
		return deletedNode.getData();
	}

	public void push(int data) {
		insertAtBegining(data);
	}

	public int pop() {
		return deleteFromBegining();
	}

	public void printStack() {
		if (isEmpty()) {
			System.out.println("[]");
			return;
		}
		Node currentNode = head;
		while (currentNode != null) {
			System.out.println(currentNode);
			currentNode = currentNode.getNext();
		}
	}

}

public class StackUsingLinkedList {
	public static void main(String[] args) {
		StackLinkedListImplementation stack = new StackLinkedListImplementation();

		System.out.println("----Assert push operation in stack::---------");
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.printStack();
		System.out.println("----------------------------------------------------");

		System.out.println("----Assert pop operation in stack::---------");
		int poppedElement = stack.pop();
		System.out.println(poppedElement);
		stack.printStack();
		System.out.println("----------------------------------------------------");

		System.out.println("----Assert push operation in stack::---------");
		stack.push(40);
		stack.printStack();
		System.out.println("----------------------------------------------------");

	}
}
