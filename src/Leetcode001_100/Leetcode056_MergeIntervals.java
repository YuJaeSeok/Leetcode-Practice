package Leetcode001_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi]
 * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 
 * @author DeLL
 */
public class Leetcode056_MergeIntervals {
	public int[][] merge(int[][] intervals) {
		if (intervals.length == 0) return new int[0][2];
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}	
		});
		
		List<int[]> merged = new ArrayList<>();
		for (int i = 0; i < intervals.length; i++) {
			int left = intervals[i][0];
			int right = intervals[i][1];
			if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < left) {
				merged.add(new int[]{left, right});
			} else {
				merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], right);
			}
		}
		return merged.toArray(new int[merged.size()][]);
	}
}
