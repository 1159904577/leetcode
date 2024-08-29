import sun.misc.LRUCache;

import javax.management.relation.RelationServiceNotRegisteredException;
import java.util.Deque;
import java.util.LinkedList;

public class leetcode_148 {


    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode tmp = slow.next;
        slow.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode res = new ListNode();
        ListNode h = res;
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }

        return res.next;
    }

    //超时
    public ListNode sortList1(ListNode head) {

        if (head == null || head.next == null)
            return head;

        Deque<ListNode> stack1 = new LinkedList<>();
        Deque<ListNode> stack2 = new LinkedList<>();

        ListNode p = head;
        stack1.push(p);
        p = p.next;

        while (p != null) {
            if (p.val <= stack1.peek().val) {
                stack1.push(p);
            } else {
                while (!stack1.isEmpty() && p.val > stack1.peek().val) {
                    stack2.push(stack1.pop());
                }
                stack1.push(p);
                while (!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }
            }

            p = p.next;
        }

        ListNode newhead = stack1.peek();
        ListNode q = newhead;
        while (!stack1.isEmpty()) {
            q.next = stack1.pop();
            q = q.next;
        }

        return newhead;
    }
}
