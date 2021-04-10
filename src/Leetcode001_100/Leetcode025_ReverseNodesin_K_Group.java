package Leetcode001_100;

/**
 * ��K��һ�鷴ת����
 * @author DeLL
 *
 */
public class Leetcode025_ReverseNodesin_K_Group {
	public ListNode reverseKGroup(ListNode head, int k) {
		// ����һ������ͷ���
		ListNode hair = new ListNode(0);
		hair.next = head;
		ListNode pre = hair;
		
		while (head != null) {
			ListNode tail = pre;
			// �鿴ʣ�ಿ���Ƿ���ڵ���k
			for (int i = 0; i < k; i++) {
				tail = tail.next;
				if (tail == null) {
					return hair.next;
				}
			}
			
			ListNode next = tail.next;
			ListNode[] reverse = reverse(head, tail);
			head = reverse[0];
			tail = reverse[1];
			
			// �����������½ӻ�ԭ����
			pre.next = head;
			tail.next = next;
			pre = tail;
			head = tail.next;
		}
		return hair.next;
	}

	private ListNode[] reverse(ListNode head, ListNode tail) {
		ListNode prev = tail.next;
		ListNode p = head;
		while (prev != tail) {
			ListNode next = p.next;
			p.next = prev;
			prev = p;
			p = next;
		}
		return new ListNode[] {tail, head};
	}
}
