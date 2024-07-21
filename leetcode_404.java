public class leetcode_404 {
    public static void main(String[] args) {

    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root==null)
            return 0;
        int leftValue = sumOfLeftLeaves(root.left);
        int rightValue = sumOfLeftLeaves(root.right);

        int midValue=0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            midValue=root.left.val;
        }
        int sum = midValue + leftValue + rightValue;
        return sum;
    }
}
