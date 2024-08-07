public class leetcode_337 {
    public static void main(String[] args) {

    }

    public static int rob(TreeNode root) {
        int[] res = robAction((root));
        return Math.max(res[0],res[1]);
    }

    public static int[] robAction(TreeNode root){
        int[] res = new int[2];
        if (root == null) {
            return res;
        }

        int[] left = robAction(root.left);
        int[] right = robAction(root.right);

        //虽然不偷当前节点，不代表不偷当前节点的下下层节点
        res[0] = Math.max(left[0],left[1])+Math.max(right[0],right[1]);

        //因为要用到左右孩子节点dp值，所以需要后续遍历
        res[1] = root.val+left[0]+right[0];
        return res;

    }


}
