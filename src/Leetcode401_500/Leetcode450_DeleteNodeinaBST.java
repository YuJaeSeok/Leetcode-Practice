package Leetcode401_500;

/**
 * 二叉搜索树删除一个字符，再次形成二叉搜索树
 * @author DeLL
 *
 */
public class Leetcode450_DeleteNodeinaBST {
	
	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) return null;
		
		if (key > root.val) root.right = deleteNode(root.right, key);
		else if (key < root.val) root.left = deleteNode(root.left, key);
		else {
			if (root.left == null && root.right == null) root = null;
			else if (root.right != null) {
				root.val = rightProcessor(root);
				root.right = deleteNode(root.right, root.val);
			} else {
				root.val = leftProcessor(root);
				root.left = deleteNode(root.left, root.val);
			}
		}
		return root;
	}

	private int leftProcessor(TreeNode root) {
		root = root.left;
		while (root.right != null) root = root.right;
		return root.val;
	}

	private int rightProcessor(TreeNode root) {
		root = root.right;
		while (root.left != null) root = root.left;
		return root.val;
	}
}

class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;
	TreeNode(){}
	TreeNode(int val) { this.val = val; }
	TreeNode(TreeNode left, TreeNode right, int val) {
		this.left = left;
		this.right = right;
		this.val = val;
	}
}
