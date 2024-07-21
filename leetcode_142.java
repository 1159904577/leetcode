public class leetcode_142 {
    public static void main(String[] args) {
        ListNode node4= new ListNode(-4);
        ListNode node3= new ListNode(0,node4);
        ListNode node2= new ListNode(2,node3);
        ListNode head = new ListNode(3,node2);
        node4.next=node2;

        System.out.println(detectCycle(head).val);
    }

    public static ListNode detectCycle(ListNode head){
        ListNode fast=head;
        ListNode slow=head;
        ListNode start=head;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                ListNode interNode=slow;
                while(interNode!=start){
                    interNode=interNode.next;
                    start=start.next;
                }
                return start;
            }
        }

        return null;
    }
}
