package Leetcode001_100;

/**
 * 外观数列
 * 没啥，递归就行
 * @author DeLL
 *
 */
public class Leetcode038_CountandSay {
	public String countAndSay(int n) {
		if (n == 1) return "1";
		String s = countAndSay(n - 1);
		StringBuilder res = new StringBuilder();
		// 记录每个数字的开始索引
		int start = 0;
		for (int i = 1; i < s.length(); i++) {
			// 当数字发生改变时执行
			if (s.charAt(i) != s.charAt(start)) {
				res.append(i - start).append(s.charAt(start));
				start = i;
			}
		}
		// 字符串最后一个数字
		res.append(s.length() - start).append(s.charAt(start));
		return res.toString();
	}
}
