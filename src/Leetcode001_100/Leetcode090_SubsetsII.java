package Leetcode001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * @author DeLL
 *
 */
public class Leetcode090_SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		
		if (nums == null || nums.length == 0) return res;
		Arrays.sort(nums);
		dfs(nums, 0, new ArrayList<>(), res);
		return res;
    }

	private void dfs(int[] nums, int start, List<Integer> tmp, List<List<Integer>> res) {
		res.add(new ArrayList<>(tmp));
		for (int i = start; i < nums.length; i++) {
			// 和上个数字相同就跳过
			if (i > start && nums[i] == nums[i - 1]) continue;
			tmp.add(nums[i]);
			dfs(nums, i + 1, tmp, res);
			tmp.remove(tmp.size() - 1);
		}
	}
}
