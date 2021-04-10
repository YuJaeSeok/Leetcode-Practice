package Leetcode101_200;

/**
 * 相交链表
 * 双指针 走过一样的路 最终会美好的相遇
 * @author DeLL
 *
 */
public class Leetcode160_IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		
		if (headA == null && headB == null) return null;
		
		ListNode pA = headA;
		ListNode pB = headB;
		while (pA != pB) {
			pA = (pA == null) ? headB : pA.next;
			pB = (pB == null) ? headA : pB.next;
		}
		return pA;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}
