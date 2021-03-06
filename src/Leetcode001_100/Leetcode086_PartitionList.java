package Leetcode001_100;

/**
 * ๅ้้พ่กจ
 * https://leetcode-cn.com/problems/partition-list/
 * @author DeLL
 *
 */
public class Leetcode086_PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode small = new ListNode(0);
		ListNode sHead = small;
		ListNode large = new ListNode(0);
		ListNode lHead = large;
		
		while (head != null) {
			if (head.val < x) {
				small.next = head;
				small = small.next;
			} else {
				large.next = head;
				large = large.next;
			}
			head = head.next;
		}
		large.next = null;
		small.next = lHead.next;
		return sHead.next;
    }
}
