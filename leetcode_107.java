import java.util.*;

public class leetcode_107 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue =new LinkedList<>();
        Stack<List<Integer>> sl = new Stack<>();
        List<List<Integer>> ll =new ArrayList<>();
        if(root==null){
            return sl;
        }
        queue.offer(root);
        TreeNode temp;
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> l=new LinkedList<>();
            while (size>0){
                temp=queue.poll();
                l.add(temp.val);
                if (temp.left!=null){
                    queue.offer(temp.left);
                }
                if (temp.right!=null){
                    queue.offer(temp.right);
                }
                size--;
            }
            sl.push(l);
        }
        while (!sl.isEmpty()){
            ll.add(sl.pop());
        }
        return ll;
    }
}
