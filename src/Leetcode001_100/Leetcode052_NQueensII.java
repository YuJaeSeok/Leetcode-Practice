package Leetcode001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode052_NQueensII {
	public int totalNQueens(int n) {
		List<List<String>> res = new ArrayList<List<String>>();
		int[] queens = new int[n];
		Arrays.fill(queens, -1);
		
		Set<Integer> columns = new HashSet<Integer>();
        Set<Integer> diagonals1 = new HashSet<Integer>();
        Set<Integer> diagonals2 = new HashSet<Integer>();
        backTrack(res, queens, n, 0, columns, diagonals1, diagonals2);
        return res.size();
	}

	private void backTrack(List<List<String>> res, int[] queens, int n, int row,
			Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
		if (row == n) {
			List<String> board = generate(queens, n);
			res.add(board);
		} else {
			for (int i = 0; i < n; i++) {
				if (columns.contains(i)) continue;
				int diagonal1 = row - i;
				if (diagonals1.contains(diagonal1)) continue;
				int diagonal2 = row + i;
				if (diagonals2.contains(diagonal2)) continue;
				
				queens[row] = i;
				columns.add(i);
				diagonals1.add(row - i);
				diagonals2.add(row + i);
				backTrack(res, queens, n, row + 1, columns, diagonals1, diagonals2);
				queens[row] = -1;
				columns.remove(i);
				diagonals1.remove(diagonal1);
				diagonals2.remove(diagonal2);
			}
		}
	}

	private List<String> generate(int[] queens, int n) {
		List<String> board = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			char[] rows = new char[n];
			Arrays.fill(rows, '.');
			rows[queens[i]] = 'Q';
			board.add(new String(rows));
		}
		return board;
	}
}
