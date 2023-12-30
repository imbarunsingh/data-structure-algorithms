package com.hashtable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

// Refer Sumit Mallick
public class HashMapImpl {

	public static void main(String[] args) throws Exception {
		HashMap hashMap = new HashMap();
		
		hashMap.put(11, "India");
		hashMap.put(12, "India");
		hashMap.put(13, "India");
		
		List<Object> keySet = hashMap.keyset();
		keySet.forEach(x -> System.out.println(x));

	}

}
class HMNode<K, V> {
	K key;
	V value;
	
	public HMNode(K key, V value) {
		this.key = key;
		this.value = value;
	}
}

class HashMap<K, V> {	
	
	private int size;
	private LinkedList<HMNode> buckets[];
	
	public HashMap() {
		initBuckets(4);
		size = 0;
	}
	public HashMap(int bucketSize) {
		initBuckets(bucketSize);
		size = 0;
	}
	private void initBuckets(int N) {
		buckets = new LinkedList[N];
		//Initializing linked list
		for (int i = 0; i < buckets.length; i++) {
			buckets[i] = new LinkedList<>();
		}		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void put(K key, V value) throws Exception {
		int bi = hashFn(key);
		int di = getIndexWithinBucket(key, bi);
		
		if(di != -1) {
			//update
			HMNode hmNode = buckets[bi].get(di);
			hmNode.value = value;
		} else {
			//insert
			HMNode hmNode = new HMNode(key, value);
			buckets[bi].add(hmNode);
			size++;
		}	
		double loadFactor = size * 1.0 / buckets.length;
		if(loadFactor > 2.0) {
			reHash();
		}
	}
	
	private void reHash() throws Exception {
		LinkedList<HMNode> oba[] = buckets;
		
		initBuckets(oba.length * 2);
		size = 0;
		for (int i = 0; i < oba.length; i++) {
			for (HMNode node : oba[i]) {
				put((K)node.key, (V)node.value);
			}
		}
	}
	public V get(K key, V value) {
		int bi = hashFn(key);
		for(HMNode hmNode : buckets[bi]) {
			if(hmNode.key.equals(key)) {
				return (V) hmNode.value;
			}
		}
		return null;
	}
	
	public boolean contains(K key) {
		int bi = hashFn(key);
		int di = getIndexWithinBucket(key, bi);		
		return di == -1 ? false : true;
	}
	
	public boolean remove(K key) throws Exception {
		int bi = hashFn(key);
		int di = getIndexWithinBucket(key, bi);		
		
		if(di != -1) {
			buckets[bi].remove(di);
			size--;
			return true;
		}
		return false;
	}
	
	public List<K> keyset() throws Exception {
		List<K> keys = new ArrayList<>();
		for (int i = 0; i < buckets.length; i++) {
			for (HMNode hmNode : buckets[i]) {
				keys.add((K) hmNode.key);
			}
		}
		return keys;
	} 
	
	
	private int getIndexWithinBucket(K key, int bi) {
		LinkedList<HMNode> linkedList = buckets[bi];
		int di = 0;
		for (HMNode hmNode : linkedList) {
			if(hmNode.key.equals(key)) {
				return di;
			}
			di++;
		}
		return -1;		
	}
	
	private int hashFn(K key) {
		int hc = key.hashCode();
		return Math.abs(hc) % buckets.length;
	}
	
}