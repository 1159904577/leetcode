public class leetcode_0207 {
    public static void main(String[] args) {
        ListNode node5=new ListNode(5);
        ListNode node4= new ListNode(4,node5);
        ListNode node3= new ListNode(3,node4);
        ListNode node2= new ListNode(2,node3);
        ListNode headA = new ListNode(1,node2);

        ListNode node7= new ListNode(7,node3);
        ListNode node6= new ListNode(6,node7);
        ListNode headB = new ListNode(1,node6);

        System.out.println(getIntersectionNode(headA,headB).val);
    }

    /*
        面试题02.07.链表相交
     */
    public static ListNode getIntersectionNode(ListNode headA,ListNode headB){
        int sizeA=0;
        int sizeB=0;
        ListNode pA=headA;
        ListNode pB=headB;
        while(pA!=null){
            sizeA++;
            pA=pA.next;
        }
        while(pB!=null){
            sizeB++;
            pB=pB.next;
        }

        while(headA!=null && sizeA>sizeB){
            headA=headA.next;
            sizeA--;
        }

        while (headB!=null && sizeA<sizeB){
            headB=headB.next;
            sizeB--;
        }

        while (headA!=null && headB!=null){
            if(headA==headB){
                return headA;
            }
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }
}
