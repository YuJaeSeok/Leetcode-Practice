package Leetcode201_300;

/**
 * 反转链表
 * @author DeLL
 *
 */
public class Leetcode206_ReverseLinkedList {

	// 迭代
	public ListNode reverseList(ListNode head) {
		if (head == null) return null;
		
		ListNode pre = null;
		ListNode cur = head;
		
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
	
	// 递归
	public ListNode reverseList1(ListNode head) {
		if (head == null) return null;
		
		ListNode tmp = head.next;
		ListNode node = reverseList1(head.next);
		tmp.next = head;
		head.next = null;
		return node;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}
