import java.util.*;

public class leetcode_145 {
    public static void main(String[] args) {

    }

    public static List<Integer> postorderTraversal(TreeNode root){

        /*
            统一迭代遍历
         */
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
                stack.push(null);
                if (temp.right!=null){
                    stack.push(temp.right);
                }
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
        后序遍历：左右中
        入栈顺序：中左右
        出栈顺序：中右左
        将“中左右”逆过来得到后序遍历“左右中”
     */
//    public static List<Integer> postorderTraversal(TreeNode root){
//        List<Integer> res = new ArrayList<>();
//        if(root==null){
//            return res;
//        }
//        Deque<TreeNode> stack = new LinkedList<>();
//        TreeNode temp;
//        stack.push(root);
//        while (!stack.isEmpty()){
//            temp=stack.pop();
//            res.add(temp.val);
//            if (temp.left!=null){
//                stack.push(temp.left);
//            }
//            if (temp.right!=null){
//                stack.push(temp.right);
//            }
//        }
//        Collections.reverse(res);
//        return res;
//    }
    /*
        递归遍历
     */
//    public static List<Integer> postorderTraversal(TreeNode root){
//        List<Integer> list = new ArrayList<>();
//        postOrder(list,root);
//        return list;
//    }
//
//    public static void postOrder(List<Integer> list,TreeNode root){
//        if(root==null){
//            return;
//        }
//        postOrder(list,root.left);
//        postOrder(list,root.right);
//        list.add(root.val);
//    }
}
