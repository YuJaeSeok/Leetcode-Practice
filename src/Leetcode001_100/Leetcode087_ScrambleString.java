package Leetcode001_100;

/**
 * 扰乱字符串
 * @author DeLL
 *
 */
public class Leetcode087_ScrambleString {
	public boolean isScramble(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		int m = s1.length();
		int n = s2.length();
		
		if (m != n) return false;
		
		boolean[][][] dp = new boolean[m][m][m + 1];
		// 初始化单个字符的情况
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				dp[i][j][1] = c1[i] == c2[j];
			}
		}
		
		// 枚举区间长度2-m
		for (int len = 2; len <= m; len++) {
			// 枚举s中的启始位置
			for (int i = 0; i <= m - len; i++) {
				// 枚举T中的启始位置
				for (int j = 0; j <= m - len; j++) {
					// 枚举划分位置
					for (int k = 1; k <= len - 1; k++) {
						// 第一种情况， s1 -》 T1， s2 -》 T2
						if (dp[i][j][k] && dp[i + k][j + k][len - k]) {
							dp[i][j][len]= true;
							break;
						}
						// 第二种情况，s1 -》T2，s2 -》 T1
						// s1起点i，T2起点j + 前面那段长度len - k，s2起点i + 前面长度k
						if (dp[i][j + len - k][k] && dp[i + k][j][len - k]) {
							dp[i][j][len] = true;
							break;
						}
					}
				}
			}
		}
		return dp[0][0][m];
    }
}
