package Leetcode001_100;

/**
 * 删除排序链表中的重复元素 II
 * 
 * 存在一个按升序排列的链表,给你这个链表的头节点 head,请你删除链表中所有存在数字重复情况的节点，只保留原始链表中没有重复出现的数字。
 * 返回同样按升序排列的结果链表。
 * @author DeLL
 *
 */
public class Leetcode082_RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) return head;
		
		ListNode node = new ListNode(0, head);
		ListNode cur = node;
		while (cur.next != null && cur.next.next != null) {
			if (cur.next.val == cur.next.next.val) {
				int val = cur.next.val;
				while (cur.next != null && cur.next.val == val) {
					cur.next = cur.next.next;
				}
			} else {
				cur = cur.next;
			}
		}
		return node.next;
    }
}
