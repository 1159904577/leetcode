import java.util.*;

public class leetcode_101 {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();
        deque.offerFirst(1);
        deque.offerFirst(2);
        deque.offerFirst(3);
        deque.offerFirst(4);
        deque.offerLast(1);
        deque.offerLast(2);
        deque.offerLast(3);
        deque.offerLast(4);
        System.out.println(deque);
        while (!deque.isEmpty()){
            System.out.println(deque.pollFirst());
            System.out.println(deque.pollLast());
        }

    }

    public static boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root.left);
        deque.offerLast(root.right);
        while (!deque.isEmpty()){
            TreeNode leftNode=deque.pollFirst();
            TreeNode rightNode=deque.pollLast();
            if(leftNode==null && rightNode ==null){
                continue;
            }
            if (leftNode==null && rightNode!=null){
                return false;
            }
            if(leftNode!=null){
                if(rightNode==null){
                    return false;
                }
                if (rightNode!=null && rightNode.val!=leftNode.val){
                    return false;
                }
            }
            deque.offerFirst(leftNode.left);
            deque.offerFirst(leftNode.right);
            deque.offerLast(rightNode.right);
            deque.offerLast(rightNode.left);
        }
        return true;
    }
}
