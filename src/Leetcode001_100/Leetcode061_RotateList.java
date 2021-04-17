package Leetcode001_100;

/**
 * 旋转链表
 * @author DeLL
 *
 */
public class Leetcode061_RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if (k == 0 || head == null || head.next == null) return head;
		
		int n = 1;
		ListNode pre = head;
		while (pre.next != null) {
			pre = pre.next;
			n++;
		}
		int add = n - k % n;
		if (add == n) return head;
		pre.next = head;
		while (add-- > 0) {
			pre = pre.next;
		}
		ListNode res = pre.next;
		pre.next = null;
		return res;
	}
}
