package Leetcode001_100;

/**
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * @author DeLL
 *
 */
public class Leetcode072_EditDistance {
	public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		
		// 如果有空字符串
		if (m * n == 0) return m + n;
		
		int[][] dp = new int[m + 1][n + 1];
		
		// 边界状态初始化
		for (int i = 0; i < m + 1; i++) {
			dp[i][0] = i;
		}
		for (int j = 0; j < n + 1; j++) {
			dp[0][j] = j;
		}
		
		// 计算所有的dp值
		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				int left = dp[i - 1][j] + 1;
				int down = dp[i][j - 1] + 1;
				int leftDown = dp[i - 1][j - 1];
				if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
					leftDown++;
				}
				dp[i][j] = Math.min(left, Math.min(down, leftDown));
			}
		}
		return dp[m][n];
	}
}
