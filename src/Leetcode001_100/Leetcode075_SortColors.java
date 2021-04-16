package Leetcode001_100;

/**
 * 颜色分类
 * https://leetcode-cn.com/problems/sort-colors/
 * 常熟空间的一趟扫描算法
 * @author DeLL
 *
 */
public class Leetcode075_SortColors {
	public void sortColors(int[] nums) {
		int zero = -1;
		int one = 0;
		int two = nums.length;
		while (one < two) {
			if (nums[one] == 0) {
				swap(nums, ++zero, one++);
			} else if (nums[one] == 2) {
				swap(nums, --two, one);
			} else {
				++one;
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
}
