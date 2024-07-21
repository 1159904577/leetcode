import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leetcode_257 {
    public static void main(String[] args) {

    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();// 存最终的结果
        if (root == null) {
            return res;
        }
        List<Integer> paths = new ArrayList<>();// 作为结果中的路径
        traversal(root, paths, res);
        return res;
    }

    public static void traversal(TreeNode root , List<Integer> paths ,List<String> res){
        //前序遍历
        paths.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<paths.size()-1;i++){
                sb.append(i).append("->");
            }
            sb.append(paths.get(paths.size()-1));
            res.add(sb.toString());
            return;
        }
        if(root.left!=null){
            traversal(root.left,paths,res);
            //当左节点不为空时，遍历玩左节点后，paths里最后的path为包含左节点的path
            //应移除后遍历右节点
            //回溯
            paths.remove(paths.size()-1);
        }
        if (root.right != null) {
            traversal(root.right,paths,res);
            paths.remove(paths.size()-1);
        }
    }
}
