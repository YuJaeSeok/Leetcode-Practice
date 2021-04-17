package Leetcode001_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 左右文本对齐
 * @author DeLL
 *
 */
public class Leetcode068_TextJustification {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res = new ArrayList<>();
		int n = words.length;
		
		int i = 0, j = 0, cLen = 0;
		for (; j < n; j++) {
			if (cLen + words[j].length() + (j - i) > maxWidth) {
				StringBuilder tmp = new StringBuilder();
				if (j - i == 1) {
					tmp.append(words[i]);
					while (tmp.length() < maxWidth) tmp.append(" ");
					i = j;
					cLen = words[j].length();
					res.add(tmp.toString());
					continue;
				}
				
				int e = (maxWidth - cLen) / (j - i - 1);
				int l = (maxWidth - cLen) % (j - i - 1);
				
				for (int k = i; k < i + l; k++) {
					tmp.append(words[k]);
					tmp.append(addSpaces(e + 1));
				}
				for (int k = i + l; k < j - 1; k++) {
					tmp.append(words[k]);
					tmp.append(addSpaces(e));
				}
				tmp.append(words[j - 1]);
				
				i = j;
				res.add(tmp.toString());
				cLen = words[j].length();
			} else {
				cLen = cLen + words[j].length();
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int k = i; k < n; k++) {
			sb.append(words[k]);
			if (k != n - 1) sb.append(" ");
		}
		while (sb.length() < maxWidth) sb.append(" ");
		res.add(sb.toString());
		
		return res;
	}
	
	/**
	 * 添加空格
	 * @param num
	 * @return
	 */
	private String addSpaces(int num) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < num; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}
}
