import java.util.Deque;
import java.util.LinkedList;

public class leetcode_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists,0,lists.length-1);
    }

    public ListNode merge(ListNode[] lists,int left ,int right){
        if (left==right)
            return lists[left];
        if (left>right)
            return null;
        int mid = (left+right) >> 1;
        return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    public ListNode mergeTwoLists(ListNode a,ListNode b){
        if (a==null ||  b==null){
            return a!=null?a:b;
        }

        ListNode head=new ListNode();
        ListNode p=head;
        while (a!=null && b!=null){
            if (a.val<=b.val){
                p.next=a;
                a=a.next;
            }else {
                p.next=b;
                b=b.next;
            }
            p=p.next;
        }
        p.next=a==null?b:a;
        return head.next;
    }
}
