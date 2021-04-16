package Leetcode001_100;

/**
 * 删除排序链表中的重复元素
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * 返回同样按升序排列的结果链表。
 * @author DeLL
 *
 */
public class Leetcode083_RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) return head;
		
		head.next = deleteDuplicates(head.next);
		return head.val == head.next.val ? head.next : head;
	}
}
