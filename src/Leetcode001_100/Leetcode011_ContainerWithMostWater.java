package Leetcode001_100;

public class Leetcode011_ContainerWithMostWater {
	public int maxArea(int[] height) {
		if (height.length <= 1) return -1;
		
		int res = 0;
		int i = 0;
		int j = height.length - 1;
		while (i < j) {
			int h = Math.min(height[i], height[j]);
			res = Math.max(res, h * (j - i));
			if (height[i] < height[j]) {
				++i;
			} else {
				--j;
			}
		}
		return res;
	}
}
