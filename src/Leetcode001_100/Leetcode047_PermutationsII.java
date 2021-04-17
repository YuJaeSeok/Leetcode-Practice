package Leetcode001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 回溯
 * @author DeLL
 *
 */
public class Leetcode047_PermutationsII {
	boolean[] flag;
	public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
		
		List<Integer> output = new ArrayList<>();
		flag = new boolean[nums.length];
		Arrays.sort(nums);
		backTrack(nums, output, res, 0);
		return res;
	}

	private void backTrack(int[] nums, List<Integer> output, List<List<Integer>> res, int start) {
		// 所有数都填完了
		if (start == nums.length) {
			res.add(new ArrayList<>(output));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			// 和上个数字相同就跳过
			if (flag[i] || (i > 0 && nums[i] == nums[i - 1] && !flag[i - 1])) continue;
			// 动态维护数组
			output.add(nums[i]);
			flag[i] = true;
			// 继续递归填充下一个数
			backTrack(nums, output, res, start + 1);
			flag[i] = false;
			// 清空
			output.remove(start);
		}
	}
}
