import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode_102 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(5);
        TreeNode root5 = new TreeNode(6);
        TreeNode root6 = new TreeNode(7);
        TreeNode root7 = new TreeNode(8);
        root.left=root1;
        root.right=root2;
        root2.left=root3;
        root2.right=root4;
        root3.left=root5;
        root4.left=root6;
        root4.right=root7;

//        System.out.println(levelOrder(root));
        int[][] ints = levelOrder(root).stream().map(x -> x.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][]::new);
//        System.out.println(levelOrder(root).toArray(new int[0][]));
//        System.out.println(ints);
        for(int row=0;row<ints.length;row++){
            for(int col=0;col<ints[row].length;col++){
                System.out.print(ints[row][col]+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ll = new ArrayList<>();

        if (root==null){
            return ll;
        }
        Queue<TreeNode> queue =  new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            List<Integer> l = new ArrayList<>();
            while (size>0){
                TreeNode cur = queue.poll();
                l.add(cur.val);
                if (cur.left!=null){
                    queue.offer(cur.left);
                }
                if (cur.right!=null){
                    queue.offer(cur.right);
                }
                size--;
            }

            ll.add(l);
        }

        return ll;
    }


    public static List<List<Integer>> levelOrder1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ll = new ArrayList<>();
        if (root==null){
            return ll;
        }

        queue.offer(root);
        TreeNode top;
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> l=new LinkedList<>();
            while (size>0){
                top=queue.poll();
                l.add(top.val);
                if(top.left!=null){
                    queue.offer(top.left);
                }
                if (top.right!=null){
                    queue.offer(top.right);
                }
                size--;
            }
            ll.add(l);
        }


        return ll;
    }
}
