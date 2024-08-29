import java.util.ArrayList;
import java.util.List;

public class leetcode_234 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> l = new ArrayList<>();
        while (head!=null){
            l.add(head.val);
            head=head.next;
        }
        int left=0;
        int right=l.size()-1;
        while (left<right){
            if (l.get(left)!=l.get(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
