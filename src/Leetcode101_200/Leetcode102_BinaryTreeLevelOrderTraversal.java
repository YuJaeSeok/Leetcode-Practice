package Leetcode101_200;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树的层序遍历
 * @author DeLL
 *
 */
public class Leetcode102_BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
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
		return res;
	}
}
