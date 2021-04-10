package Leetcode001_100;

import java.util.HashMap;
import java.util.Map;

public class Leetcode001_TwoSum {
	
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++) {
			Integer id = map.get(target - nums[i]);
			if (id != null) {
				return new int[] {id, i};
			}
			map.put(nums[i], i);
		}
		return null;
	}
}
