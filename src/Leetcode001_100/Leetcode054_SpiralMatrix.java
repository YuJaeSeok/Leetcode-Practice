package Leetcode001_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 * @author DeLL
 *
 */
public class Leetcode054_SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> order = new ArrayList<>();
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return order;
		
		int rows = matrix.length;
		int columns = matrix[0].length;
		int left = 0;
		int right = columns - 1;
		int top = 0;
		int bottom = rows - 1;
		while (left <= right && top <= columns) {
			for (int column = left; column <= right; column++) {
				order.add(matrix[top][column]);
			}
			for (int row = top + 1; row <= bottom; row++) {
				order.add(matrix[row][right]);
			}
			if (left < right && top < bottom) {
				for (int column = right - 1; column > left; column--) {
					order.add(matrix[bottom][column]);
				}
				for (int row = bottom; row > top; row--) {
					order.add(matrix[row][left]);
				}
			}
			left++;
			right--;
			top++;
			bottom--;
		}
		return order;
	}
}
