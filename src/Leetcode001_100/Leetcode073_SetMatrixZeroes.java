package Leetcode001_100;

/**
 * 矩阵置零
 * @author DeLL
 *
 */
public class Leetcode073_SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		if (matrix == null || matrix.length == 0) return;
		
		int m = matrix.length;
		int n = matrix[0].length;
		boolean[] rows = new boolean[m];
		boolean[] cols = new boolean[n];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					rows[i] = cols[j] = true;
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (rows[i] || cols[j]) {
					matrix[i][j] = 0;
				}
			}
		}
	}
}
