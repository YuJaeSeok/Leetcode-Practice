package Leetcode001_100;

/**
 * 没啥技巧，找好规律就行
 * @author DeLL
 *
 */
public class Leetcode006_ZigZagConversion {
	public String convert(String s, int numRows) {
		if (numRows == 1) return s;
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= numRows; i++) {
			if (i == 1 || i == numRows) {
				for (int j = i - 1; j < s.length(); j += 2 * (numRows - 1)) {
					sb.append(s.charAt(j));
				}
			} else {
				int tag = 0;
				int j = i - 1;
				while (j < s.length()) {
					sb.append(s.charAt(j));
					if (tag % 2 == 0) {
						tag++;
						j += 2 * (numRows - i);
					} else {
						tag++;
						j += 2 * (i - 1);
					}
				}
			}
		}
		return sb.toString();
	}
}
