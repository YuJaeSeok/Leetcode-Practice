package Leetcode001_100;

/**
 * 最后一个单词的长度
 * @author DeLL
 *
 */
public class Leetcode058_LengthofLastWord {
	public int lengthOfLastWord(String s) {
		if (s.equals("") || s.equals(" ")) return 0;
		
		String str = s.trim();
		if (str.length() == 0) return 0;
		else {
			String[] words = str.split(" ");
			return words[words.length - 1].trim().length();
		}
	}
}
