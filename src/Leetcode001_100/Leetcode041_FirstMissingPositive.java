package Leetcode001_100;

/**
 * 缺失的第一个正数
 * @author DeLL
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 */
public class Leetcode041_FirstMissingPositive {
	public int firstMissingPositive(int[] nums) {
		if (nums == null || nums.length == 0) return -1;
		
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] <= 0) {
				nums[i] = len + 1;
			}
		}
		
		for (int i = 0; i < len; i++) {
			int num = Math.abs(nums[i]);
			if (num <= len) {
				nums[num - 1] = -Math.abs(nums[num - 1]);
			}
		}
		
		for (int i = 0; i < len; i++) {
			if (nums[i] > 0) {
				return i + 1;
			}
		}
		return len + 1;
	}
}
