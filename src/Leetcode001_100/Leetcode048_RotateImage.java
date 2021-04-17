package Leetcode001_100;

/**
 * 旋转图像
 * https://leetcode-cn.com/problems/rotate-image/
 * 找好对应关系就行
 * @author DeLL
 *
 */
public class Leetcode048_RotateImage {
	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0) return;
		
		int n = matrix.length;
		int[][] newMatrix = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				newMatrix[j][n - i - 1] = matrix[i][j];
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = newMatrix[i][j];
			}
		}
	}
}
