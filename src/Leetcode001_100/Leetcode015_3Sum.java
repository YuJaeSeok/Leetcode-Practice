package Leetcode001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode015_3Sum {
	
	public static List<List<Integer>> threeSum(int[] nums) {
		int len = nums.length;
		List<List<Integer>> res = new ArrayList<>();
		
		if (nums == null || len < 3) return res;
		
		Arrays.sort(nums);
		
		for(int i = 0; i < len; i++) {
			
			// ��ֹ���������nums[i]����0��˵��֮�������ȫ������0���Ѿ�û�б�Ҫ������
			if (nums[i] > 0) return res;
			if (i > 0 && nums[i] == nums[i - 1]) continue;
			int left = i + 1;
			int right = len - 1;
			
			while (left < right) {
				if(nums[i] + nums[left] + nums[right] == 0) {
					List<Integer> list = new ArrayList<Integer>();
					list.addAll(Arrays.asList(nums[i], nums[left], nums[right]));
					res.add(list);
					
					// �ظ��Ļ� ����ָ���ƶ�
					while(left < right && nums[left] == nums[left + 1]) left++;
					while(left < right && nums[right] == nums[right - 1]) right--;
					
					// ����ָ���ƶ�
					left++;
					right--;
				} else if (nums[i] + nums[left] + nums[right] > 0) {
					right--;
				} else {
					left++;
				}
			}
		}
		return res;
	}
}
