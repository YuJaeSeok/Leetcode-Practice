package Leetcode001_100;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 * 
 * 智障写法，主要是不想写二分了。。
 * @author DeLL
 *
 */
public class Leetcode034_FindFirstandLastPositionofElementinSortedArray {
	public int[] searchRange(int[] nums, int target) {
		int[] results = new int[]{-1, -1};
		if (nums == null || nums.length == 0) return results;
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				results[0] = i;
				break;
			}
		}
		
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] == target) {
				results[1] = i;
				break;
			}
		}
		return results;
	}
}
