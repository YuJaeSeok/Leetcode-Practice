package Leetcode001_100;

/**
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @author DeLL
 *
 */
public class Leetcode053_MaximumSubarray {
	// 动态规划
	public int maxSubArray(int[] nums) {
		int pre = 0;
		int max = nums[0];
		for (int num : nums) {
			pre = Math.max(pre + num, num);
			max = Math.max(max, pre);
		}
		return max;
	}
}
