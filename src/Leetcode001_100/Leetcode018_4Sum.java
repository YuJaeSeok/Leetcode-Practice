package Leetcode001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ÅÅĞò¼ÓË«Ö¸Õë
 * @author DeLL
 *
 */
public class Leetcode018_4Sum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 4) return res;
		Arrays.sort(nums);
		
		int len = nums.length;
		for (int i = 0; i < len - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
			if (nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) continue;
			
			for (int j = i + 1; j < len - 2; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) continue;
				if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
				if (nums[i] + nums[j] + nums[len - 1] + nums[len - 2] < target) continue;
				
				int left = j + 1;
				int right = len - 1;
				while (left < right) {
					int sum = nums[i] + nums[j] + nums[left] + nums[right];
					if (sum == target) {
						res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
						while (left < right && nums[left] == nums[left + 1]) left++;
						left++;
						while (left < right && nums[right] == nums[right - 1]) right--;
						right--;
					} else if (sum > target) {
						right--;
					} else {
						left++;
					}
				}
			}
		}
		return res;
	}
}
