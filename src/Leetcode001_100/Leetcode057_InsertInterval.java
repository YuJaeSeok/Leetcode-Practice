package Leetcode001_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 插入区间
 * @author DeLL
 *
 */
public class Leetcode057_InsertInterval {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		int left = newInterval[0];
		int right = newInterval[1];
		boolean placed = false;
		List<int[]> ansList = new ArrayList<>();
		for (int[] interval : intervals) {
			if (interval[0] > right) {
				// 待插入数组最小，在最左边
				if (!placed) {
					ansList.add(new int[]{left, right});
					placed = true;
				}
				ansList.add(interval);
			} else if (interval[1] < left) {
				// 待插入数组最大，在最右边
				ansList.add(interval);
			} else {
				// 与插入区间有交集，计算他们的并集
				left = Math.min(left, interval[0]);
				right = Math.max(right, interval[1]);
			}
		}
		if (!placed) {
			ansList.add(new int[]{left, right});
		}
		int[][] ans = new int[ansList.size()][2];
		for (int i = 0; i < ansList.size(); i++) {
			ans[i] = ansList.get(i);
		}
		return ans;
	}
}
