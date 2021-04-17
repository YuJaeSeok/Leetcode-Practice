package Leetcode001_100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * n=4, k=2
 * @author DeLL
 *
 */
public class Leetcode077_Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		if (k <= 0 || n < k) return res;
		
		Deque<Integer> paths = new ArrayDeque<>();
		// 从1开始
		dfs(n, k, 1, paths, res);
		return res;
	}

	private void dfs(int n, int k, int start, Deque<Integer> paths, List<List<Integer>> res) {
		// 递归终止条件是paths的长度等于k
		if (paths.size() == k) {
			res.add(new ArrayList<>(paths));
			return;
		}
		
		// 遍历所有可能的起点
		for (int i = start; i <= n; i++) {
			paths.addLast(i);
			// 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
			dfs(n, k, i + 1, paths, res);
			// 重点理解这里：深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
			paths.removeLast();
		}
	}
}
