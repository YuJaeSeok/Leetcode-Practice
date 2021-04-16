package Leetcode001_100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 复原IP地址
 * @author DeLL
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 */
public class Leetcode093_RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		int len = s.length();
		List<String> res = new ArrayList<>();
		if (len > 12 || len < 4) return res;
		
		Deque<String> path = new ArrayDeque<>(4);
		int splitTimes = 0;
		dfs(s, len, splitTimes, 0, path, res);
		return res;
	}

	private void dfs(String s, int len, int split, int begin, Deque<String> path, List<String> res) {
		if (begin == len) {
			// 终止条件
			if (split == 4) {
				res.add(String.join(".", path));
			}
			return;
		}
		
		// 剩下的不够了，就退出剪枝，len - begin表示剩余的还未分割的字符串的位数
		if (len - begin < (4 - split) || len - begin > 3 * (4 - split)) return;
		
		for (int i = 0; i < 3; i++) {
			if (begin + i >= len) break;
			int ipSegment = judgeIfIpSegment(s, begin, begin + i);
			if (ipSegment != -1) {
				// 判断时候是IP段，做截取
				path.addLast(ipSegment + "");
				dfs(s, len, split + 1, begin + i + 1, path, res);
				path.removeLast();
			}
		}
	}

	/**
	 * 判断s的子区间[left, right]是否能成为一个ip段
	 * @param s
	 * @param begin
	 * @param i
	 * @return
	 */
	private int judgeIfIpSegment(String s, int left, int right) {
		int len = right - left + 1;
		// 大于1位时，不能以0开头
		if (len > 1 && s.charAt(left) == '0') return -1;
		
		// 转为int类型
		int res = 0;
		for (int i = left; i <= right; i++) {
			res = res * 10 + s.charAt(i) - '0';
		}
		
		if (res > 255) return -1;
		return res;
	}
}