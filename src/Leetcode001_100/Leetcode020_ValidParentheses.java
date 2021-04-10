package Leetcode001_100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * ÓÐÐ§À¨ºÅ
 * @author DeLL
 *
 */
public class Leetcode020_ValidParentheses {
	public boolean isValid(String s) {
		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put(']', '[');
		map.put('}', '{');
		
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				char top = stack.isEmpty() ? '#' : stack.pop();
				if (top != map.get(c)) {
					return false;
				}
			} else {
				stack.push(c);
			}
		}
		return stack.isEmpty();
	}
}
