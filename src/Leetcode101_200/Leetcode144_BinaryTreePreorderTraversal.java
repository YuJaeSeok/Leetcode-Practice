package Leetcode101_200;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的前序遍历
 * @author DeLL
 *
 */
public class Leetcode144_BinaryTreePreorderTraversal {
	
	// 使用栈
	public List<Integer> preorderTraversal(TreeNode root) {
		LinkedList<TreeNode> stack = new LinkedList<>();
		LinkedList<Integer> res = new LinkedList<>();
		
		if (root == null) return res;
		
		stack.add(root);
		while (!stack.isEmpty()) {
			TreeNode node = stack.pollLast();
			res.add(node.val);
			if (node.right != null) {
				stack.add(node.right);
			}
			if (node.left != null) {
				stack.add(node.left);
			}
		}
		return res;
	}
	
	// 使用递归
	public List<Integer> preorderTraversal1(TreeNode root) {
        List <Integer> results = new ArrayList<>();
        recursive(root, results);
        return results;
    }

    private void recursive(TreeNode node, List<Integer> results) {
        if(node == null) {
            return;
        }
        results.add(node.val);
        recursive(node.left, results);
        recursive(node.right, results);
    }
}
