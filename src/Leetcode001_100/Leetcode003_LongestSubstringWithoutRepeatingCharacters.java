package Leetcode001_100;

import java.util.HashMap;
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
}
