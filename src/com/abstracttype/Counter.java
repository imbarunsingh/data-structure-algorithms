package com.abstracttype;

public class Counter {

	private String name;
	private int counter;

	public Counter(String name) {		
		this.name = name;
	}

	public void increment() {
		counter++;
	}

	public int getCurrentValue() {		
		return counter;
	}

	@Override
	public String toString() {
		return "Counter [name=" + name + ", counter=" + counter + "]";
	}	

}
