package com.doubly.linkedlist;

//Linked List class structure
public class Node {

	private int data;
	private Node next;
	private Node previous;

	public Node() {}
	
	public Node(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}	
}
