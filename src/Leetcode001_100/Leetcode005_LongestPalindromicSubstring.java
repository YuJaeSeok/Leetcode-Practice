package Leetcode001_100;

public class Leetcode005_LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		int n = s.length();
		boolean[][] dp = new boolean[n][n];
		String ans = "";
		// l是步长，l=0代表只有一个字符 l=1只需要判断两个字符是否相等即可
		for (int l = 0; l < n; ++l) {
			for (int i = 0; i + l < n; ++i) {
				int j = i + l;
				if (l == 0) {
					dp[i][j] = true;
				} else if (l == 1) {
					dp[i][j] = (s.charAt(i) == s.charAt(j));
				} else {
					dp[i][j] = (s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1];
				}
				if (dp[i][j] && l + 1 > ans.length()) {
					ans = s.substring(i, i + l + 1);
				}
			}
		}
		return ans;
	}
}
