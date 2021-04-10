package Leetcode101_200;

import java.util.LinkedHashMap;

/**
 * 手写LRU有不少坑，直接用LinkedHashMap
 * @author DeLL
 *
 */
public class Leetcode146_LRUCache extends LinkedHashMap<Integer, Integer> {
	
	private int capacity;

	public Leetcode146_LRUCache(int capacity) {
		super(capacity, 0.75f, true);
		this.capacity = capacity;
	}
	
	public int get(int key) {
		return super.getOrDefault(key, -1);
	}
	
	public void put(int key, int value) {
		super.put(key, value);
	}

	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
		return size() > capacity;
	}
}
