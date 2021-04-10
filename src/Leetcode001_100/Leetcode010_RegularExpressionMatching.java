package Leetcode001_100;

public class Leetcode010_RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		int sLen = s.length();
		int pLen = p.length();
		
		boolean[][] dp = new boolean[sLen + 1][pLen + 1];
		dp[0][0] = true;
		for (int i = 0; i <= sLen; i++) {
			for (int j = 1; j <= pLen; j++) {
				if (p.charAt(j - 1) == '*') {
					dp[i][j] = dp[i][j - 2];
					if (match(s, p, i, j - 1)) {
						dp[i][j] = dp[i][j] || dp[i - 1][j];
					}
				} else {
					if (match(s, p, i, j)) {
						dp[i][j] = dp[i - 1][j - 1];
					}
				}
			}
		}
		return dp[sLen][pLen];
	}

	private boolean match(String s, String p, int i, int j) {
		if (i == 0) return false;
		if (p.charAt(j - 1) == '.') return true;
		return s.charAt(i - 1) == p.charAt(j - 1);
	}
}
