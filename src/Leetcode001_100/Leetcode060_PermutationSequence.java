package Leetcode001_100;

import java.util.Arrays;

/**
 * 排列序列
 * @author DeLL
 *
 */
public class Leetcode060_PermutationSequence {
	/**
	 * 记录数字是否使用过
	 */
	private boolean[] used;
	
	/**
	 * 阶乘数组
	 */
	private int[] factorial;
	
	private int n;
	
	private int k;
	
	/**
	 * 
	 * @param n
	 * @param k
	 * @return
	 */
	public String getPermutation(int n, int k) {
		this.k = k;
		this.n = n;
		calculateFactorial(n);
		
		// 查找全排列需要的不布尔数组
		used = new boolean[n + 1];
		Arrays.fill(used, false);
		
		StringBuilder path = new StringBuilder();
		dfs(0, path);
		return path.toString();
	}

	private void dfs(int start, StringBuilder path) {
		if (start == n) return;
		
		// 计算还未确定的数字的全排列的个数，第1次进入的时候是n-1
		int cur = factorial[n - 1 - start];
		for (int i = 1; i <= n; i++) {
			if (used[i]) continue;
			if (cur < k) {
				k -= cur;
				continue;
			}
			path.append(i);
			used[i] = true;
			dfs(start + 1, path);
			// 注意 1：不可以回溯（重置变量），算法设计是「一下子来到叶子结点」，没有回头的过程
            // 注意 2：这里要加 return，后面的数没有必要遍历去尝试了
			return;
		}
	}

	/**
	 * 计算阶乘数组
	 * @param n
	 */
	private void calculateFactorial(int n) {
		factorial = new int[n + 1];
		factorial[0] = 1;
		for (int i = 1; i <= n; i++) {
			factorial[i] = factorial[i - 1] * i;
		}
	}
}
