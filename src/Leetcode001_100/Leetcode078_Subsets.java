package Leetcode001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集  进阶（有重复的元素，Leetcode090）
 * 深度优先搜索
 * https://leetcode-cn.com/problems/subsets/
 * @author DeLL
 *
 */
public class Leetcode078_Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		
		if (nums == null || nums.length == 0) return res;
		Arrays.sort(nums);
		dfs(nums, 0, new ArrayList<>(), res);
		return res;
    }

	private void dfs(int[] nums, int start, List<Integer> tmp, List<List<Integer>> res) {
		res.add(new ArrayList<>(tmp));
		for (int i = start; i < nums.length; i++) {
			tmp.add(nums[i]);
			dfs(nums, i + 1, tmp, res);
			tmp.remove(tmp.size() - 1);
		}
	}
}
