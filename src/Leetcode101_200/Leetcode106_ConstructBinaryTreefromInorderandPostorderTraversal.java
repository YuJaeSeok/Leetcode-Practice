package Leetcode101_200;

/**
 * 从中序与后序遍历构造二叉树
 * @author DeLL
 *
 */
public class Leetcode106_ConstructBinaryTreefromInorderandPostorderTraversal {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return helper(inorder, postorder,
				postorder.length - 1, 0, inorder.length - 1);
	}

	private TreeNode helper(int[] inorder, int[] postorder, int postEnd, int inStart, int inEnd) {
		if (inStart > inEnd) return null;
		
		int cur = postorder[postEnd];
		TreeNode node = new TreeNode(cur);
		
		int inIndex = 0;
		// 找到根节点的右子节点
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == cur) {
				inIndex = i;
			}
		}
		TreeNode left = helper(inorder, postorder,
				postEnd - (inEnd - inIndex) - 1, inStart, inIndex - 1);
		TreeNode right = helper(inorder, postorder, postEnd - 1, inIndex + 1, inEnd);
		node.left = left;
		node.right = right;
		return node;
	}
}
