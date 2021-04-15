package Leetcode301_400;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 反转字符串的元音字母 leetcode
 * @author DeLL
 *
 */
public class Leetcode345_ReverseVowelsofaString {
	
	final static HashSet<Character> vowels = new HashSet<Character>(
			Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
	
	public String reverseVowels(String s) {
		int left = 0;
		int right = s.length() - 1;
		char[] results = new char[s.length()];
		while (left <= right) {
			char ci = s.charAt(left);
			char cr = s.charAt(right);
			if (!vowels.contains(ci)) {
				results[left++] = ci;
			} else if (!vowels.contains(cr)) {
				results[right--] = cr;
			} else {
				results[left++] = cr;
				results[right--] = ci;
			}
		}
		return new String(results);
	}

	public static void main(String[] args) {
		System.out.println(new Leetcode345_ReverseVowelsofaString().reverseVowels("leetcode"));
	}
}
