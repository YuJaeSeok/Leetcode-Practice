package Leetcode001_100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 回溯+剪枝
 * 
 * 组合总和
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target的组合。
 * candidates中的数字可以无限制重复被选取
 * 
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * @author DeLL
 *
 */
public class Leetcode039_CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		int len = candidates.length;
		List<List<Integer>> res = new ArrayList<>();
		if (len == 0) return res;
		
		Arrays.sort(candidates);
		Deque<Integer> path = new ArrayDeque<>();
		dfs(candidates, 0, target, path, res);
		return res;
	}

	/**
	 * @param candidates 原数组
	 * @param start 搜索起点
	 * @param target 每减去一个元素，target减小
	 * @param path 搜索路径，一个栈
	 * @param res 结果集
	 */
	private void dfs(int[] candidates, int start, int target, Deque<Integer> path, List<List<Integer>> res) {
		// 如果target为0，搜索完毕，将这条路径添加到结果集
		if (target == 0) {
			res.add(new ArrayList<>(path));
			return;
		}
		
		for (int i = start; i < candidates.length; i++) {
			if (target - candidates[i] < 0) break;
			path.addLast(candidates[i]);
			// 由于元素可以重复利用，这里的起点仍然是i
			dfs(candidates, i, target - candidates[i], path, res);
			
			// 状态重置
			path.removeLast();
		}
	}
}
