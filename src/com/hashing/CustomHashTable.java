package com.hashing;

public class CustomHashTable {

	private String hashArray[];
	private int arraySize;
	int size = 0; // counter for number of elements in the hash table

	public CustomHashTable(int numberOfSlots) {

		numberOfSlots = isPrime(numberOfSlots) ? numberOfSlots : getNextPrime(numberOfSlots);

		hashArray = new String[numberOfSlots];
		arraySize = hashArray.length;

	}

	private int getNextPrime(int numberOfSlots) {

		numberOfSlots = numberOfSlots + 1;
		while (!isPrime(numberOfSlots)) {
			numberOfSlots = numberOfSlots + 1;
		}
		return numberOfSlots;
	}

	private boolean isPrime(int numberOfSlots) {
		int i = 2;
		while (i < numberOfSlots / 2) {
			if (numberOfSlots % i == 0) {
				return false;
			}
			i++;
		}
		return true;
	}
	
	// Returns Ideal index position where we would like to store or search element in the hash table
	private int hashFunc1(String word) {
		int hashVal = word.hashCode();
		hashVal %= arraySize;
		if(hashVal < 0) { // Since hashVal return can be -ve
			hashVal += arraySize;
		}
		return hashVal;
	}
	
	// Returns step size greater than 0
	private int hashFunc2(String word) {
		int hashVal = word.hashCode();
		hashVal %= arraySize;
		if(hashVal < 0) { // Since hashVal return can be -ve
			hashVal += arraySize;
		}
		return 3 - (hashVal % 3); // 3 -> using a prime number less than the array size
	}
	
	public void insert(String word) {
		
		int index = hashFunc1(word); 
		int stepSize = hashFunc2(word);
		
		while(hashArray[index] != null) { // if Collision happens
			index = index + stepSize;
			index = index % arraySize;
		}
		hashArray[index] = word;
		size++;
		System.out.println("Inserted word: "+word);
	}
	
	public String find(String word) {
		int index = hashFunc1(word);
		int stepSize = hashFunc2(word);
		
		while(hashArray[index] != null) {
			if(hashArray[index].equals(word)) {
				System.out.println("The Search word :"+ word + " found at index: "+index);
				return hashArray[index];
			}
			index = index + stepSize;
			index %= arraySize;
		}
		System.out.println("The Search word :"+ word + " was not found");
		return hashArray[index]; // If not found 
	}
	
	public void displayTable() {
		for (int i = 0; i < arraySize; i++) {
			if(hashArray[i] != null) {
				System.out.print(hashArray[i] + " ");
			} else {
				System.out.print("*" + " "); // Represents null
			}
			
			
		}
	}

}
