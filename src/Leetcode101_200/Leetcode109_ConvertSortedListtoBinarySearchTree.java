package Leetcode101_200;

/**
 * 将有序链表转换为二叉搜索树
 * @author DeLL
 *
 */
public class Leetcode109_ConvertSortedListtoBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) return null;
		if (head.next == null) return new TreeNode(head.val);
		ListNode pre = head;
		ListNode p = pre.next;
		ListNode q = p.next;
		
		// 找到链表的中间节点
		while (q.next != null && q != null) {
			pre = pre.next;
			p = pre.next;
			q = q.next.next;
		}
		
		// 将中点左边的链表分开
		pre.next = null;
		TreeNode root = new TreeNode(p.val);
		// 左节点再次从头开始
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(p.next);
		return root;
	}
}
