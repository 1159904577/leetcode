import java.util.*;

public class leetcode_25 {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);

        a.next = b;


        ListNode listNode = reverseKGroup(a, 2);

        while (listNode != null) {
            System.out.println("--------------------");
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public static ListNode reverseKGroup(ListNode head, int k) {

        if (head.next==null || k==1){
            return head;
        }


        int index = 0;
        ListNode node = new ListNode();
        ListNode count = head;
        Deque<ListNode> stack = new LinkedList<>();
        ListNode res = node;
        while (count != null) {

            if (index % k == 0) {
                while (!stack.isEmpty()) {
                    node.next = stack.pop();
                    node = node.next;
                }
                if (index == k) {
                    res = res.next;
                }
            }
            ListNode tmp = count;
            stack.push(tmp);
            count = count.next;
            index++;
        }

        if (stack.size()==k){
            while (!stack.isEmpty()){
                node.next=stack.pop();
                node=node.next;
            }
            node.next=null;
            if(index==k)
                return res.next;
        }

        while (!stack.isEmpty()) {
            node.next = stack.pollFirst();
        }


        return res;
    }
}
