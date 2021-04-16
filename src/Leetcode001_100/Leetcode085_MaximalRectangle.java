package Leetcode001_100;

/**
 * 最大矩形
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 * https://leetcode-cn.com/problems/maximal-rectangle/
 * @author DeLL
 *
 */
public class Leetcode085_MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0) return 0;
		
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					dp[i][j] = (j == 0 ? 0 : dp[i][j - 1]) + 1;
				}
			}
		}
		
		int res = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '0') continue;
				int width = dp[i][j];
				int area = width;
				for (int k = i - 1; k >= 0; k--) {
					width = Math.min(width, dp[k][j]);
					area = Math.max(area, (i - k + 1) * width);
				}
				res = Math.max(res, area);
			}
		}
		return res;
    }
}
