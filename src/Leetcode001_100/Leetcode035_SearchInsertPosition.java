package Leetcode001_100;

/**
 * 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * @author DeLL
 *
 */
public class Leetcode035_SearchInsertPosition {
	public int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length == 0) return -1;
		
		int len = nums.length;
		int left = 0;
		int right = len - 1;
		// 看看nums里有没有target
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) return mid;
			if (target < nums[mid]) {
			    right = mid - 1;
			} else {
				if (nums[mid] < target) {
				    left = mid + 1;
				}
			}
		}
		
		// 没有的话，查找插入下标
		if (len == 1) return nums[0] > target ? 0 : 1;
		for (int i = 0; i <= len - 2; i++) {
			if (target < nums[0]) return 0;
			if (target > nums[len - 1]) return len;
			else {
				if (target > nums[i] && target < nums[i + 1]) return i + 1;
			}
		}
		return -1;
	}
}
