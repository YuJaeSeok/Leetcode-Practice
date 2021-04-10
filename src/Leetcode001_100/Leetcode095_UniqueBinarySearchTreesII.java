package Leetcode001_100;

import java.util.LinkedList;
import java.util.List;

public class Leetcode095_UniqueBinarySearchTreesII {
	
	public List<TreeNode> generateTrees(int n) {
		if(n <= 0) return new LinkedList<TreeNode>();
		return generateTrees(1, n);
	}

	private List<TreeNode> generateTrees(int start, int end) {
		List<TreeNode> list = new LinkedList<TreeNode>();
		
		if (start > end) {
			list.add(null);
			return list;
		}
		
		for(int i = start; i <= end; i++) {
			List<TreeNode> subLeftTree = generateTrees(start, i - 1);
			List<TreeNode> subRightTree = generateTrees(i + 1, end);
			for (TreeNode left : subLeftTree) {
				for (TreeNode right : subRightTree) {
					TreeNode node = new TreeNode(i);
					node.left = left;
					node.right = right;
					list.add(node);
				}
			}
		}
		return list;
	}

}
