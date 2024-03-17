package com.string.questions;

// Time Complexity : O(L) l is the length of the string
//For code refer : striver and concept on Code help : babbar
class TrieNode {
	char data;
	TrieNode child[];
	boolean isEndOfString;

	public TrieNode() {
		super();
		this.child = new TrieNode[26];
		this.isEndOfString = false;
	}

	public boolean containsKey(char ch) {
		// ch - 'a' is for fining index in child array with char subtraction
		return child[ch - 'a'] != null;
	}

	public void put(char ch, TrieNode node) {
		child[ch - 'a'] = node;
	}

	public TrieNode get(char ch) {
		return child[ch - 'a'];
	}

	public void setEnd(boolean isEndOfString) {
		this.isEndOfString = isEndOfString;
	}

	public boolean getEnd() {
		return this.isEndOfString;
	}
}

public class TrieImplementation {

	private TrieNode root;

	public TrieImplementation() {
		this.root = new TrieNode();
	}

	// Inserts a word into the trie
	public void insert(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			if (!node.containsKey(word.charAt(i))) {
				node.put(word.charAt(i), node);
			}
			node = node.get(word.charAt(i));
		}
		node.setEnd(true);
	}

	// Search a word into the trie
	public boolean search(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			if (!node.containsKey(word.charAt(i))) {
				return false;
			}
			node = node.get(word.charAt(i));
		}		
		return node.getEnd(); // if it has reached the end which means we found the word 
	}
	
	// Returns if there is any word in the trie that starts with the given prefix
	public boolean startsWith(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			if (!node.containsKey(word.charAt(i))) {
				return false;
			}
			node = node.get(word.charAt(i));
		}		
		return true; 
	}
	
	public static void main(String[] args) {
		TrieImplementation trieImplementation = new TrieImplementation();
		trieImplementation.insert("apple");
		trieImplementation.insert("apps");
		trieImplementation.insert("abs");
		
		System.out.println("Is String found :: " + trieImplementation.search("apple"));
		System.out.println("Is String found :: " + trieImplementation.search("appium"));
		
	}

}