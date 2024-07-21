public class leetcode_110 {
    public static void main(String[] args) {

    }

    public static boolean isBalanced(TreeNode root) {
        return getHight(root)!=-1;
    }

    public static int getHight(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftHeight = getHight(root.left);
        if(leftHeight==-1){
            return -1;
        }
        int rightHight = getHight(root.right);
        if(rightHight==-1){
            return -1;
        }
        if(Math.abs(leftHeight-rightHight)>1){
            return -1;
        }
        return Math.max(leftHeight,rightHight)+1;
    }
}
