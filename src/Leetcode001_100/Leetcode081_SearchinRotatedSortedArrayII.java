package Leetcode001_100;

/**
 * 搜索旋转排序数组 II
 * @author DeLL
 *
 */
public class Leetcode081_SearchinRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0) return false;
		
		int start = 0;
		int end = nums.length - 1;
		int mid;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (target == nums[mid]) return true;
			
			// 去除重复字符
			if (nums[start] == nums[mid]) {
				start++;
				continue;
			}
			
			// 前半部分有序
			if (nums[start] < nums[mid]) {
				// 若target在前半部分
				if (target < nums[mid] && target >= nums[start]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				// 后半部分有序
				if (target > nums[mid] && target <= nums[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		
		// 一直没找到，返回false
		return false;
    }
}
