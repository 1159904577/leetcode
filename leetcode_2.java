import java.util.LinkedList;

public class leetcode_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int jinwei=0;
        ListNode res= new ListNode();
        ListNode p = res;
        int a=0;
        int b=0;
        while (l1!=null || l2!=null){
            if (l1!=null){
                a=l1.val;
            }else
                a=0;
            if (l2!=null){
                b=l2.val;
            }else
                b=0;

            int num=a+b+jinwei;

            if (num>=10){
                jinwei=1;
                num-=10;
            }else {
                jinwei=0;
            }
            p.next=new ListNode(num);
            p=p.next;
            if (l1!=null){
                l1=l1.next;
            }
            if (l2!=null){
                l2=l2.next;
            }

        }
        if (jinwei == 1) {
            p.next=new ListNode(1);
        }
        return res.next;
    }
}
