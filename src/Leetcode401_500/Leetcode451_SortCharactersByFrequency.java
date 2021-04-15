package Leetcode401_500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 按出现次数降序输出字符
 * 桶排序
 * @author DeLL
 *
 */
public class Leetcode451_SortCharactersByFrequency {
	public String frequencySort(String s) {
		if (s.length() == 0) return "";
		
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		List<Character>[] buckets = new ArrayList[s.length() + 1];
		for (char c : map.keySet()) {
			int value = map.get(c);
			if (buckets[value] == null) {
				buckets[value] = new ArrayList<>();
			}
			buckets[value].add(c);
		}
		
		StringBuilder res = new StringBuilder();
		for (int i = buckets.length - 1; i >= 0; i--) {
			if (buckets[i] == null) continue;
			for (char c : buckets[i]) {
				for (int j = 0; j < i; j++) {
					res.append(c);
				}
			}
		}
		return res.toString();
	}
}
