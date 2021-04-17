package Leetcode101_200;

/**
 * 将有序数组转换为二叉搜索树
 * @author DeLL
 *
 */
public class Leetcode108_ConvertSortedArraytoBinarySearchTree {
	public TreeNode sortedArrayToBST(int[] nums) {
		// 左右等分建立左右子树，中间节点作为根节点，递归该过程
		return nums == null ? null : buildTree(nums, 0, nums.length - 1);
	}

	private TreeNode buildTree(int[] nums, int left, int right) {
		// 终止条件
		if (left > right) return null;
		
		int mid = left + (right - left) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = buildTree(nums, left, mid - 1);
		root.right = buildTree(nums, mid + 1, right);
		return root;
	}
}
