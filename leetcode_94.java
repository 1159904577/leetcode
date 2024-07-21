import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class leetcode_94 {
    public static void main(String[] args) {

    }

    /*
        统一迭代遍历
     */
    public static List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new LinkedList<>();
        if (root==null){
            return res;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        TreeNode temp;
        while (!stack.isEmpty()){
            temp=stack.peek();
            if (temp!=null){
                stack.pop();
                if (temp.right!=null){
                    stack.push(temp.right);
                }
                stack.push(temp);
                stack.push(null);
                if (temp.left!=null){
                    stack.push(temp.left);
                }
            }else{
                stack.pop();
                temp=stack.pop();
                res.add(temp.val);
            }
        }
        return res;
    }

    /*
        迭代遍历
     */
//    public static List<Integer> inorderTraversal(TreeNode root){
//        List<Integer> res = new ArrayList<>();
//        if(root==null){
//            return res;
//        }
//        Deque<TreeNode> stack = new LinkedList<>();
//        TreeNode cur=root;
//        while (cur!=null || !stack.isEmpty()){
//            if(cur!=null){
//                stack.push(cur);
//                cur=cur.left;
//            }else {
//                cur=stack.pop();
//                res.add(cur.val);
//                cur=cur.right;
//            }
//
//        }
//        return res;
//    }

    /*
        递归遍历
     */
//    public static List<Integer> inorderTraversal(TreeNode root){
//        List<Integer> list = new ArrayList<>();
//        inOrder(list,root);
//        return list;
//    }
//
//    public static void inOrder(List<Integer> list,TreeNode root){
//        if(root==null){
//            return;
//        }
//        inOrder(list,root.left);
//        list.add(root.val);
//        inOrder(list,root.right);
//    }
}
