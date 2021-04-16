package Leetcode001_100;

public class Leetcode024_SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) return head;
		
		ListNode newHead = head.next;
		head.next = swapPairs(newHead.next);
		newHead.next = head;
		return newHead;
	}
}
