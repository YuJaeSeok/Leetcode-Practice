package Leetcode001_100;

public class Leetcode099_RecoverBinarySearchTree {
	
	TreeNode t1, t2, pre;
	public void recoverTree(TreeNode root) {
		 inOrder(root);
		 int tmp = t1.val;
		 t1.val = t2.val;
		 t2.val = tmp;
	}
	
	private void inOrder(TreeNode root) {
		if (root == null) return;
		inOrder(root.left);
		if (pre != null && pre.val > root.val) {
			if (t1 == null) t1 = pre;
			t2 = root;
		}
		pre = root;
		inOrder(root.right);
	}
}
