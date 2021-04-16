package Leetcode301_400;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * cbacdcbc -> acdb
 * @author DeLL
 *
 */
public class Leetcode316_RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {
		Stack<Character> stack = new Stack<>();
		HashSet<Character> set = new HashSet<>();
		HashMap<Character, Integer> map = new HashMap<>();
		
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), i);
		}
		
		for (int j = 0; j < s.length(); j++) {
			char c = s.charAt(j);
			if (!set.contains(c)) {
				while (!stack.isEmpty() && c < stack.peek() && map.get(stack.peek()) > j) {
					set.remove(stack.pop());
				}
				set.add(c);
				stack.push(c);
			}
		}
		
		StringBuilder res = new StringBuilder(stack.size());
		for (char c : stack) {
			res.append(c);
		}
		return res.toString();
	}
}
