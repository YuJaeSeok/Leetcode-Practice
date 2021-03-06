package Leetcode001_100;

/**
 * 不同路径
 * https://leetcode-cn.com/problems/unique-paths/
 * @author DeLL
 *
 */
public class Leetcode062_UniquePaths {
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i< m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[m - 1][n - 1];
	}
}
