public class leetcode_24 {
    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        ListNode q = head.next;
        ListNode cur = new ListNode(-1);
        cur.next = q;
        head = q;
        while (p != null && p.next != null) {
            cur.next = q;
            p.next = q.next;
            q.next = p;
            cur = p;
            p = p.next;
            if (p != null) {
                q = p.next;
            }

        }

        return head;

    }
}
