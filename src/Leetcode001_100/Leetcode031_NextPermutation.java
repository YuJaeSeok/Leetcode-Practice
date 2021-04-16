package Leetcode001_100;

import java.util.Arrays;

/**
 * 下一个排列
 * 找出数字序列下一个字典序的排列，如果没有，将数字重新排列成最小的列
 * @author DeLL
 *
 */
public class Leetcode031_NextPermutation {
	public void nextPermutation(int[] nums) {
		int i = nums.length - 2;
		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}
		
		if (i >= 0) {
			int j = nums.length - 1;
			while (j >= 0 && nums[i] >= nums[j]) {
				j--;
			}
			swap(nums, i, j);
		}
		reverse(nums, i + 1);
	}

	private void reverse(int[] nums, int start) {
		int left = start;
		int right = nums.length - 1;
		while (left < right) {
			swap(nums, left, right);
			left++;
			right--;
		}
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
