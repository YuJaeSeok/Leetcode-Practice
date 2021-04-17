package Leetcode101_200;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树的层序遍历 II
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 * @author DeLL
 *
 */
public class Leetcode107_BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) return res;
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int count = queue.size();
			List<Integer> list = new ArrayList<>();
			while (count > 0) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				count--;
			}
			res.add(list);
		}
		Collections.reverse(res);
		return res;
	}
}
