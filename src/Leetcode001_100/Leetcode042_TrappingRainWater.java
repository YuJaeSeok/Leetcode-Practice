package Leetcode001_100;

/**
 * 接雨水
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * @author DeLL
 *
 */
public class Leetcode042_TrappingRainWater {
	public int trap(int[] height) {
		int len = height.length;
		int[] left = new int[len];
		int[] right = new int[len];
		for (int i = 1; i < len; i++) {
			left[i] = Math.max(left[i - 1], height[i - 1]);
		}
		
		for (int i = len - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], height[i + 1]);
		}
		
		int water = 0;
		for (int i = 0; i < len; i++) {
			water += Math.max(0, Math.min(left[i], right[i]) - height[i]);
		}
		return water;
	}
}
