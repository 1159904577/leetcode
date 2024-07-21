public class leetcode_206 {
    public static void main(String args[]){
        ListNode node5=new ListNode(5);
        ListNode node4= new ListNode(4,node5);
        ListNode node3= new ListNode(3,node4);
        ListNode node2= new ListNode(2,node3);
        ListNode head = new ListNode(1,node2);
        ListNode result =reverseList(head);
        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }

    public static ListNode reverseList(ListNode head){
        if(head == null || head.next ==null){
            return head;
        }
        ListNode left=head;
        ListNode right=head.next;
        left.next=null;
        while(right!=null && right.next!=null){
            ListNode temp=right.next;
            right.next=left;
            left=right;
            right=temp;
        }
        right.next=left;
        return right;
    }
}
