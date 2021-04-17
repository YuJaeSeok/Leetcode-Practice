package Leetcode101_200;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * 二叉树的z型遍历
 * @author DeLL
 *
 */
public class Leetcode103_BinaryTreeZigzagLevelOrderTraversal {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) return new ArrayList<>();
		
		List<List<Integer>> res = new ArrayList<>();
		Deque<TreeNode> queue = new ArrayDeque<>();
		int row = -1;
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
			row++;
			if (row % 2 == 1) Collections.reverse(list);
			res.add(list);
		}
		return res;
	}
}
