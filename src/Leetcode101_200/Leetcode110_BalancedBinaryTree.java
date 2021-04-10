package Leetcode101_200;
/**
 * 判断是否是二叉平衡树
 * @author DeLL
 *
 */
public class Leetcode110_BalancedBinaryTree {
	
	private boolean result = true;
	
	public boolean isBalanced(TreeNode root) {
		maxDepth(root);
		return result;
	}

	private int maxDepth(TreeNode root) {
		if (root == null) return 0;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		if (Math.abs(left - right) > 1) result = false;
		return 1 + Math.max(left, right);
	}

	class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
}
