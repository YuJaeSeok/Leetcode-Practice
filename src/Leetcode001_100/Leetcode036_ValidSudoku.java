package Leetcode001_100;

import java.util.HashMap;

/**
 * 有效的数独
 * @author DeLL
 *
 */
public class Leetcode036_ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		// 初始化数据
		HashMap<Integer, Integer> [] rows = new HashMap[9];
		HashMap<Integer, Integer> [] columns = new HashMap[9];
		HashMap<Integer, Integer> [] boxes = new HashMap[9];
		
		for (int i = 0; i < 9; i++) {
			rows[i] = new HashMap<>();
			columns[i] = new HashMap<>();
			boxes[i] = new HashMap<>();
		}
		
		// 校验
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char num = board[i][j];
				if (num != '.') {
					int n = (int)num;
					int boxIndex = (i / 3) * 3 + j / 3;
					
					// 保存当前值
					rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
					columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
					boxes[boxIndex].put(n, boxes[boxIndex].getOrDefault(n, 0) + 1);
					
					// 检查这个字符之前是否已经出现过
					if (rows[i].get(n) > 1 || columns[j].get(n) > 1
							|| boxes[boxIndex].get(n) > 1) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
