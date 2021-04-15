package Leetcode001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 无重复的最长子串
 * @author DeLL
 *
 */
public class Leetcode003_LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0) return 0;
		Map<Character, Integer> map = new HashMap<>();
		int max = 0;
		int left = 0;
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				left = Math.max(left, map.get(s.charAt(i)) + 1);
			}
			map.put(s.charAt(i), i);
			max = Math.max(max, i - left + 1);
		}
		return max;
	}
	
	public static String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		// 构造一个桶，但是buckets[0]没有意义，所以+1
		List<Character>[] buckets = new List[s.length() + 1];
		for (char c : map.keySet()) {
			int value = map.get(c);
			
			if (buckets[value] == null) {
				buckets[value] = new ArrayList<>();
			}
			buckets[value].add(c);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = buckets.length - 1; i > 0; i--) {
			if (buckets[i] != null) {
				for (char c: buckets[i]) {
					// 遍历桶里的每一个字符
					for (int k = i; k > 0; k--) {
						sb.append(c);
					}
				}
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(frequencySort("tree"));
	}
}
