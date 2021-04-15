package Leetcode401_500;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class Leetcode460_LFUCache {
	// 存储缓存的内容
	private Map<Integer, Node> cache;
	
	// 存储每个频次相对应的双向链表
	private Map<Integer, LinkedHashSet<Node>> freqMap;
	
	// 当前缓存大小
	int size;
	
	// 缓存容量
	int capacity;
	
	// 存储当前最小频次
	int min;
	
	Leetcode460_LFUCache(int capacity) {
		cache = new HashMap<>(capacity);
		freqMap = new HashMap<>();
		this.capacity = capacity;
	}
	
	public int get(int key) {
		if (!cache.containsKey(key)) return -1;
		
		Node node = cache.get(key);
		freqInc(node);
		return node.value;
	}
	
	public void put(int key, int value) {
		if (capacity <= 0) return;
		
		Node node = cache.get(key);
		if (node != null) {
			node.value = value;
			freqInc(node);
		} else {
			if (size == capacity) {
				Node deadNode = removeNode();
				cache.remove(deadNode.key);
				size--;
			}
			
			Node newNode = new Node(key, value);
			cache.put(key, newNode);
			addNode(newNode);
			size++;
		}
	}

	private void addNode(Node node) {
		LinkedHashSet<Node> set = freqMap.get(1);
		if (set == null) freqMap.put(1, new LinkedHashSet<>());
		set.add(node);
		min = 1;
	}

	private Node removeNode() {
		LinkedHashSet<Node> set = freqMap.get(min);
		Node deadNode = set.iterator().next();
		set.remove(deadNode);
		return deadNode;
	}

	private void freqInc(Node node) {
		// 从原freq对应的链表中移除，并更新min
		int freq = node.freq;
		LinkedHashSet<Node> set = freqMap.get(freq);
		set.remove(node);
		if (freq == min && set.size() == 0) {
			min = freq + 1;
		}
		
		//加入新freq对应的链表
		node.freq++;
		LinkedHashSet<Node> newSet = freqMap.get(freq + 1);
		if (newSet == null) {
			newSet = new LinkedHashSet<>();
			freqMap.put(freq + 1, newSet);
		}
		newSet.add(node);
	}
}

class Node {
	int key;
	int value;
	int freq = 1;
	
	Node() {}
	Node(int key, int value) { this.key = key; this.value = value; }
}
