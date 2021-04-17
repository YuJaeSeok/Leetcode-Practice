package Leetcode001_100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 * @author DeLL
 *
 */
public class Leetcode046_Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		
		List<Integer> output = new ArrayList<>();
		for (int num : nums) {
			output.add(num);
		}
		int len = nums.length;
		backTrack(len, output, res, 0);
		return res;
	}

	private void backTrack(int len, List<Integer> output, List<List<Integer>> res, int start) {
		// 所有数都填完了
		if (start == len) {
			res.add(new ArrayList<>(output));
		}
		for (int i = start; i < len; i++) {
			// 动态维护数组
			Collections.swap(output, start, i);
			// 继续递归填充下一个数
			backTrack(len, output, res, start + 1);
			// 清空
			Collections.swap(output, start, i);
		}
	}
}
