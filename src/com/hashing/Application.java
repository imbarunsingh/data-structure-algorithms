package com.hashing;

public class Application {
	public static void main(String[] args) {
		
		CustomHashTable hashTable = new CustomHashTable(19);
		
		hashTable.insert("Apple");
		hashTable.insert("Africa");
		hashTable.insert("America");
		hashTable.insert("Apionion");
		
		
		hashTable.find("Africa");
		hashTable.find("Bangalore");
		
		hashTable.displayTable();
	}
}
