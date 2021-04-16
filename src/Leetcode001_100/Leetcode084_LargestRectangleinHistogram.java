package Leetcode001_100;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 柱状图中最大的矩形
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * @author DeLL
 *
 */
public class Leetcode084_LargestRectangleinHistogram {
	public int largestRectangleArea(int[] heights) {
		int res = 0;
		Deque<Integer> queue = new ArrayDeque<>();
		int[] setinals = new int[heights.length + 2];
		
		for (int i = 1; i < heights.length + 1; i++) {
			setinals[i] = heights[i - 1];
		}
		
		for (int i = 0; i < setinals.length; i++) {
			while (!queue.isEmpty() && setinals[queue.peek()] > setinals[i]) {
				int cur = queue.pop();
				res = Math.max(res, (i - queue.peek() - 1) * setinals[cur]);
			}
			queue.push(i);
		}
		return res;
	}
}
