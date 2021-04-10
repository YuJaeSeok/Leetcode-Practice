package Leetcode001_100;

/**
 * 判断是否两棵树相同
 * @author DeLL
 *
 */
public class Leetcode100_SameTree {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) return true;
		
		if (p != null && q != null && p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		} else {
			return false;
		}
	}
	
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
