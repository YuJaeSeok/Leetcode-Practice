package Leetcode001_100;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的中序遍历
 * @author DeLL
 *
 */
public class Leetcode094_BinaryTreeInorderTraversal {
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		
		if (root == null) return list;
		
		list.addAll(inorderTraversal(root.left));
		list.add(root.val);
		list.addAll(inorderTraversal(root.right));
		
		return list;
	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {
		val = x;
	}
}
