package Leetcode001_100;

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
/**
 * 最小覆盖子串
 * @author DeLL
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 */
public class Leetcode076_MinimumWindowSubstring {
	
	Map<Character, Integer> ori = new HashMap<>();
	Map<Character, Integer> cur = new HashMap<>();
	
	public String minWindow(String s, String t) {
		int tLen = t.length();
		for (int i = 0; i < tLen; i++) {
			char c = t.charAt(i);
			ori.put(c, ori.getOrDefault(c, 0) + 1);
		}
		
		int l = 0;
		int r = -1;
		int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
		int sLen = s.length();
		while (r < sLen) {
			++r;
			if (r < sLen && ori.containsKey(s.charAt(r))) {
				cur.put(s.charAt(r), cur.getOrDefault(s.charAt(r), 0) + 1);
			}
			while (check() && l <= r) {
				if (r - l + 1 < len) {
					len = r - l + 1;
					ansL = l;
					ansR = l + len;
				}
				if (ori.containsKey(s.charAt(l))) {
					cur.put(s.charAt(l), cur.getOrDefault(s.charAt(l), 0) - 1);
				}
				++l;
			}
		}
		return ansL == -1 ? "" : s.substring(ansL, ansR);
	}

	private boolean check() {
		Iterator iter = ori.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Character key = (Character) entry.getKey();
			Integer val = (Integer) entry.getValue(); 
			if (cur.getOrDefault(key, 0) < val) {
				return false;
			}
		}
		return true;
	}
}
