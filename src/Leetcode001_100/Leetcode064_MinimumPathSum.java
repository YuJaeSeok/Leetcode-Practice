package Leetcode001_100;

/**
 * 最小路径和
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * @author DeLL
 *
 */
public class Leetcode064_MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; n >= 0; n--) {
				if (i == m - 1 && j != n - 1) {
					dp[i][j] = grid[i][j] + dp[i][j + 1];
				} else if (j == n - 1 && i != m - 1) {
					dp[i][j] = grid[i][j] + dp[i + 1][j];
				} else if (j != n - 1 && i != m - 1) {
					dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
				} else {
					dp[i][j] = grid[i][j];
				}
			}
		}
		return dp[0][0];
	}
}
