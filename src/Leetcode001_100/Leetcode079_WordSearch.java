package Leetcode001_100;

/**
 * 单词搜索
 * @author DeLL
 *
 */
public class Leetcode079_WordSearch {
	private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0) return false;
		
		int m = board.length;
		int n = board[0].length;
		boolean[][] dp = new boolean[m][n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				boolean flag = check(board, dp, i, j, word, 0);
				if (flag) return true;
			}
		}
		return false;
	}

	// 回溯
	private boolean check(char[][] board, boolean[][] dp, int i, int j, String word, int k) {
		if (board[i][j] != word.charAt(k)) return false;
		else if (k == word.length() - 1) return true;
		
		dp[i][j] = true;
		boolean result = false;
		for (int[] dir : DIRECTIONS) {
			int h = i + dir[0];
			int l = j + dir[1];
			if (h >= 0 && h < board.length && l >= 0 && l < board[0].length) {
				if (!dp[h][l]) {
					if (check(board, dp, h, l, word, k + 1)) {
						result = true;
						break;
					}
				}
			}
		}
		dp[i][j] = false;
		return result;
	}
}
