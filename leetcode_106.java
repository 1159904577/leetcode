public class leetcode_106 {
    public static void main(String[] args) {

    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return buildHelper(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public static TreeNode buildHelper(int[] inorder, int inorderStart, int inorderEnd, int[] postorder, int postorderStart, int postorderEnd) {
        if (postorderStart == postorderEnd) {
            return null;
        }
        //通过后序找到根节点/中间节点
        int rootVal = postorder[postorderEnd - 1];
        TreeNode root = new TreeNode(rootVal);
        //根据中间节点找到中序遍历中左右子树
        int middleIndex;
        for (middleIndex = inorderStart; middleIndex < inorderEnd; middleIndex++) {
            if (inorder[middleIndex] == rootVal)
                break;
        }
        //寻找中序和后序左右区间都遵循左闭右开原则
        int leftInorderStart = inorderStart;
        int leftInorderEnd = middleIndex;
        int rightInorderStart = middleIndex + 1;
        int rightInorderEnd = inorderEnd;

        int leftPostorderStart = postorderStart;
        int leftPostorderEnd = leftPostorderStart + (leftInorderEnd - leftInorderStart);
        int rightPostorderStart = leftPostorderEnd;
        int rightPostorderEnd=postorderEnd-1;

        root.left=buildHelper(inorder,leftInorderStart,leftInorderEnd,postorder,leftPostorderStart,leftPostorderEnd);
        root.right=buildHelper(inorder,rightInorderStart,rightInorderEnd,postorder,rightPostorderStart,rightPostorderEnd);
        return root;
    }
}
