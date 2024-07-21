public class leetcode_19 {
    public static void main(String[] args) {
        ListNode node5=new ListNode(5);
        ListNode node4= new ListNode(4,node5);
        ListNode node3= new ListNode(3,node4);
        ListNode node2= new ListNode(2,node3);
        ListNode head = new ListNode(1,node2);
        ListNode result = removeNthFromEnd(5,head);
        while(result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
    public static ListNode removeNthFromEnd(int n,ListNode head){
        //链表操作涉及到头结点，优先考虑增加头结点
        //创建头结点，因为可能出现删除第一个节点的情况
        ListNode dummyHead = new ListNode();
        dummyHead.next=head;


        //快慢指针一次遍历,找到删除节点的前一个节点位置即可
        ListNode fast=dummyHead;
        ListNode slow=dummyHead;
        while(n>0 && fast!=null){
            fast=fast.next;
            n--;
        }
        if(fast!=null){
            fast=fast.next;
        }
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;

//        if (head.next==dummyHead.next)
//            head=head.next;
//        return head;
        return dummyHead.next;
    }
}
