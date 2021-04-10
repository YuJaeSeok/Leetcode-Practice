package Leetcode001_100;

public class Leetcode014_LongestCommonPrefix {
	
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) return "";
		
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			prefix = longestCommonPrefix(prefix, strs[i]);
			if (prefix.length() == 0) break;
		}
		return prefix;
    }

	private String longestCommonPrefix(String s1, String s2) {
		int length = Math.min(s1.length(), s2.length());
		int index = 0;
		while (index < length && s1.charAt(index) == s2.charAt(index)) {
			index++;
		}
		return s1.substring(0, index);
	}
}
