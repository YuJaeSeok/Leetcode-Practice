package Leetcode001_100;

public class Leetcode027_RemoveElement {
	public int removeElement(int[] nums, int val) {
		if (nums == null || nums.length == 0) return -1;
		
		int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
	}
}
