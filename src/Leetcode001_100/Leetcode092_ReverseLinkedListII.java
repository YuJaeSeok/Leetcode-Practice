package Leetcode001_100;

/**
 * 反转链表II
 * @author DeLL
 *
 */
public class Leetcode092_ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        // 构造一个head节点的前一节点
        ListNode first = new ListNode(0);
        first.next = head;
        ListNode pre = first;
        // 找到实际上的“头结点”
        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }
        head = pre.next;
        for (int i = m; i< n; i++) {
            ListNode tmp = head.next;
            head.next = tmp.next;
            tmp.next = pre.next;
            pre.next = tmp;
        }
        return first.next;
    }
}
