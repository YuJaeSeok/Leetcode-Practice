package Leetcode001_100;

/**
 * 删除有序数组中的重复项 II
 * @author DeLL
 *
 */
public class Leetcode080_RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;
        
        int index = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[index - 2]) {
                nums[index++] = nums[i];
            }
        }
        return index;
	}
}
