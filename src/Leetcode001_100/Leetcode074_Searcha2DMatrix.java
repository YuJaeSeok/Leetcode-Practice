package Leetcode001_100;

/**
 * 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
 * 
 * @author DeLL
 *
 */
public class Leetcode074_Searcha2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) return false;
		
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			if (target > matrix[i][n - 1]) continue;
			if (exist(matrix[i], target)) return true;
		}
		return false;
	}
	
	private boolean exist(int[] k, int target) {
		int left = 0;
		int right = k.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (target == k[mid]) return true;
			else if (target > k[mid]) left = mid + 1;
			else right = mid - 1;
		}
		return false;
	}
}
