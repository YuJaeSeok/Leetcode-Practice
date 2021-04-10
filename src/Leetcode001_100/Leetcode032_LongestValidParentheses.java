package Leetcode001_100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 最长有效括号
 * @author DeLL
 *
 */
public class Leetcode032_LongestValidParentheses {
	public int longestValidParentheses(String s) {
		int max = 0;
		Deque<Integer> queue = new ArrayDeque<>();
		queue.push(-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				queue.push(i);
			} else {
				queue.pop();
				if (queue.isEmpty()) {
					queue.push(i);
				} else {
					max = Math.max(max, i - queue.peek());
				}
			}
		}
		return max;
	}
}
