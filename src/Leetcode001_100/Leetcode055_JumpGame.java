package Leetcode001_100;

/**
 * 跳跃游戏
 * https://leetcode-cn.com/problems/jump-game/
 * @author DeLL
 *
 */
public class Leetcode055_JumpGame {
	public boolean canJump(int[] nums) {
		int len = nums.length;
		if (len <= 1) return true;
		
		int maxDis = nums[0];
		for (int i = 1; i < len - 1; i++) {
			if (i <= maxDis) {
				maxDis = Math.max(maxDis, nums[i] + i);
			}
		}
		return maxDis >= len - 1;
	}
}
