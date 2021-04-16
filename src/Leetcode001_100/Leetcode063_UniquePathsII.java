package Leetcode001_100;

/**
 * 不同路径II
 * https://leetcode-cn.com/problems/unique-paths-ii/
 * @author DeLL
 *
 */
public class Leetcode063_UniquePathsII {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
		
		// 第一列只能从上面经过，如果为1的话，跳出循环，说明不能经过该点
		for (int i = 0; i < obstacleGrid.length; i++) {
			if (obstacleGrid[i][0] != 1) dp[i][0] = 1;
			else break;
		}
		
		// 第一行只能从左边经过，如果为1的话，跳出循环，说明不能经过该点
		for (int j = 0; j < obstacleGrid[0].length; j++) {
			if (obstacleGrid[0][j] != 0) dp[0][j] = 1;
			else break;
		}
		
		for (int k = 1; k < obstacleGrid.length; k++) {
			for (int n = 1; n < obstacleGrid[0].length; n++) {
				if (obstacleGrid[k][n] == 1) dp[k][n] = 1;
				else dp[k][n] = dp[k - 1][n] + dp[k][n - 1];
			}
		}
		return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
	}
}
