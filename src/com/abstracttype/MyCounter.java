package com.abstracttype;

import java.util.LinkedList;
import java.util.List;

public class MyCounter {
	public static void main(String[] args) {
		Counter counter = new Counter("My Counter");
		counter.increment();
		counter.increment();
		counter.increment();
		counter.increment();
		
		System.out.println("My Count::"+counter.getCurrentValue());
		
		List<String> linkedList = new LinkedList<String>();
		
	}

}
