public class leetcode_160 {

    //双指针走到末尾知道a/b的差值即可
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p=headA;
        ListNode q=headB;

        while (p!=null){
            while (p!=q){
                if (q.next!=null){
                    q=q.next;
                }else {
                    break;
                }
            }
            if (p==q){
                return p;
            }
            p=p.next;
            q=headB;
        }
        return null;
    }
}
