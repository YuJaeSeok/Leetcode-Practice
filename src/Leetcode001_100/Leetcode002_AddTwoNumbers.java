package Leetcode001_100;

/**
 * @author DeLL
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 */
public class Leetcode002_AddTwoNumbers {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode p = l1;
		ListNode q = l2;
		int sum = 0;
		
		while (q != null) {
			if (p.next == null && q.next != null) {
				p.next = new ListNode(0);
			}
			if (p.next != null && q.next == null) {
				q.next = new ListNode(0);
			}
			int sumAll = sum + p.val + q.val;
			p.val = sumAll % 10;
			sum = sumAll / 10;
			if (p.next == null && q.next == null && sum != 0) {
				p.next = new ListNode(sum);
			}
			p = p.next;
			q = q.next;
		}
		return l1;
	}
}

class ListNode {
	 int val;
	 ListNode next;
	 ListNode(int x) { val = x; }
}
