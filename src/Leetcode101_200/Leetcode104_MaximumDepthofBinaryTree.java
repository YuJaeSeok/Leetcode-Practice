package Leetcode101_200;

/**
 * 二叉树的最大深度
 * @author DeLL
 *
 */
public class Leetcode104_MaximumDepthofBinaryTree {
	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
}
