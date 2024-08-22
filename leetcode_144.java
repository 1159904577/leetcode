import java.time.temporal.Temporal;
import java.util.*;

public class leetcode_144 {
    public static void main(String[] args) {

    }


    /*
        迭代遍历
     */
    public static List<Integer> preorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        if (root==null){
            return res;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur=stack.pop();
            res.add(cur.val);

            if (cur.right!=null){
                stack.push(cur.right);
            }
            if (cur.left!=null){
                stack.push(cur.left);
            }

        }

        return res;
    }

    /*
    递归遍历
     */
    public static List<Integer> preorderTraversal2(TreeNode root){
        List<Integer> list = new ArrayList<>();
        preorder(root,list);
        return list;
    }

    public static void preorder(TreeNode root,List<Integer> list){
        if (root==null){
            return;
        }
        list.add(root.val);
        preorder(root.left,list);
        preorder(root.right,list);
    }

    /*
        统一迭代遍历
     */
    public static List<Integer> preorderTraversal1(TreeNode root){
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> st = new Stack<>();
        if (root != null) st.push(root);
        while (!st.empty()) {
            TreeNode node = st.peek();
            if (node != null) {
                st.pop(); // 将该节点弹出，避免重复操作，下面再将右中左节点添加到栈中
                if (node.right!=null) st.push(node.right);  // 添加右节点（空节点不入栈）
                if (node.left!=null) st.push(node.left);    // 添加左节点（空节点不入栈）
                st.push(node);                          // 添加中节点
                st.push(null); // 中节点访问过，但是还没有处理，加入空节点做为标记。

            } else { // 只有遇到空节点的时候，才将下一个节点放进结果集
                st.pop();           // 将空节点弹出
                node = st.peek();    // 重新取出栈中元素
                st.pop();
                result.add(node.val); // 加入到结果集
            }
        }
        return result;
    }
    /*
        迭代遍历
     */
//    public static List<Integer> preorderTraversal(TreeNode root){
//        List<Integer> res = new ArrayList<>();
//        Deque<TreeNode> stack=new LinkedList<>();
//        TreeNode temp;
//        if (root==null){
//            return res;
//        }
//        stack.push(root);
//        while (!stack.isEmpty()){
//            temp=stack.pop();
//            res.add(temp.val);
//            if (temp.right!=null){
//                stack.push(temp.right);
//            }
//            if (temp.left!=null){
//                stack.push(temp.left);
//            }
//        }
//        return res;
//
//    }

    /*
        递归遍历
     */
//    public static List<Integer> preorderTraversal(TreeNode root){
//        List<Integer> list = new ArrayList<>();
//        preOrder(list,root);
//        return list;
//    }
//
//    public static void preOrder(List<Integer> list,TreeNode root){
//        if(root==null){
//            return;
//        }
//        list.add(root.val);
//        preOrder(list,root.left);
//        preOrder(list,root.right);
//    }
}
