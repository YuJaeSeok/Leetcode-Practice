package Leetcode001_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 串联所有单词的子串
 * @author DeLL
 *
 */
public class Leetcode030_SubstringwithConcatenationofAllWords {
	public static List<Integer> findSubstring(String s, String[] words) {
		if (s == null || words == null) return null;
		
		List<Integer> res = new ArrayList<>();
		int wordsLen = words.length;
		int wordLen = words[0].length();
		int len = wordsLen * wordLen;
		if (s.length() < len) return res;
		
		HashMap<String,Integer> map = new HashMap<>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		
		for (int i = 0; i < s.length() - len + 1; i++) {
			String tmp = s.substring(i, i + len);
			HashMap<String, Integer> temp = new HashMap<>();
			for (int j = 0; j < len; j += wordLen) {
				String w = tmp.substring(j, j + wordLen);
				temp.put(w, temp.getOrDefault(w, 0) + 1);
			}
			if (map.equals(temp)) res.add(i);
		}
		return res;
	}
	
	public static void main(String[] args) {
		String s = "barfoothefoobarman";
		String[] words = {"foo","bar"};
		System.out.println(findSubstring(s, words));
	}
}
