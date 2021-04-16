package Leetcode001_100;

/**
 * 不使用额外的数组空间，使用O(1)额外空间完成
 * @author DeLL
 *
 */
public class Leetcode026_RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
	}
}
