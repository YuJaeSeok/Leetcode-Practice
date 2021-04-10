package Leetcode001_100;

/**
 * 快慢指针
 * @author DeLL
 *
 */
public class Leetcode019_RemoveNthNodeFromEndofList {

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode slow = head;
		ListNode fast = head;
		
		// 快慢指针相差n个节点
		while (n-- > 0) {
			fast = fast.next;
		}
		
		if (fast == null) return head.next;
		
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow = slow.next.next;
		return head;
	}

	class ListNode {
		int val;
		ListNode next;
		ListNode(int val) {
			this.val = val;
		}
	}
}
