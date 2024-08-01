public class leetcode_203 {
    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {

        while (head!=null && head.val==val){
            head=head.next;
        }

        if (head==null){
            return head;
        }

        ListNode p=head;
        ListNode q =head.next;

        while (q!=null){
            if (q.val==val){
                q=q.next;
                p.next=q;
            }else {
                q=q.next;
                p=p.next;
            }
        }

        return head;
    }
}
