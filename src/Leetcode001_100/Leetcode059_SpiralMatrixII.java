package Leetcode001_100;

public class Leetcode059_SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		int num = 1;
		int[][] matrix = new int[n][n];
		int left = 0;
		int right = n - 1;
		int top = 0;
		int bottom = n - 1;
		while (left <= right && top <= bottom) {
			for (int col = left; col <= right; col++) {
				matrix[top][col] = num;
				num++;
			}
			for (int row = top + 1; row <= bottom; row++) {
				matrix[row][right] = num;
				num++;
			}
			if (left < right && top < bottom) {
				for (int col = right - 1; col > left; col--) {
					matrix[bottom][col] = num;
					num++;
				}
				for (int row = bottom; row > top; row--) {
					matrix[row][left] = num;
					num++;
				}
			}
			left++;
			top++;
			right--;
			bottom--;
		}
		return matrix;
	}
}
