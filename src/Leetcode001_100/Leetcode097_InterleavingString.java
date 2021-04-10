package Leetcode001_100;

public class Leetcode097_InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		int n = s1.length();
		int m = s2.length();
		int t = s3.length();
		
		if (m + n != t) return false;
	
		boolean[][] result = new boolean[n + 1][m + 1];
		result[0][0] = true;

		for(int i = 0; i <= n; i++) {
			for(int j = 0; j <= m; j++) {
				int p = i + j - 1;
				if (i > 0) {
					result[i][j] = result[i][j] || (result[i - 1][j]
							&& s1.charAt(i - 1) == s3.charAt(p));
				}
				if (j > 0) {
					result[i][j] = result[i][j] || (result[i][j - 1]
							&& s2.charAt(j - 1) == s3.charAt(p));
				}
			}
		}
		return result[n][m];
	}
}
