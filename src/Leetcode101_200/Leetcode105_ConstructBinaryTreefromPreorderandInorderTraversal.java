package Leetcode101_200;

import java.util.HashMap;
import java.util.Map;

/**
 * 从前序与中序遍历序列构造二叉树
 * @author DeLL
 *
 */
public class Leetcode105_ConstructBinaryTreefromPreorderandInorderTraversal {
	private Map<Integer, Integer> indexMap;
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int n = preorder.length;
		// 构建哈希映射，帮助我们快速定位根节点
		indexMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			indexMap.put(inorder[i], i);
		}
		return buildTreeIndex(preorder, inorder, 0, n - 1, 0, n - 1);
	}

	private TreeNode buildTreeIndex(int[] preorder, int[] inorder,
			int i, int j, int k, int l) {
		if (i > j) return null;
		
		// 前序遍历第一个节点就是根结点
		int preRoot = i;
		// 在中序遍历中定位根节点
		int inRoot = indexMap.get(preorder[preRoot]);
		
		// 先把根节点建立起来
		TreeNode root = new TreeNode(preorder[preRoot]);
		// 得到左子树的节点数目
		int leftSize = inRoot - k;
		// 递归构建左子树，并连接到根节点
		root.left = buildTreeIndex(preorder, inorder, i + 1, i + leftSize,
				k, inRoot - 1);
		// 递归构建右子树
		root.right = buildTreeIndex(preorder, inorder, i + leftSize + 1,
				j, inRoot + 1, l);
		return root;
	}
}
