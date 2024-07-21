import java.util.Arrays;

public class leetcode_654 {

    public static void main(String[] args) {

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree1(nums,0, nums.length);
    }

    public TreeNode constructMaximumBinaryTree1(int[] nums, int leftIndex, int rightIndex) {
        if (rightIndex-leftIndex<1){
            return null;
        }
        if (rightIndex - leftIndex == 1) {
            return new TreeNode(nums[leftIndex]);
        }
        int maxIndex=leftIndex;
        for (int i = leftIndex+1; i <rightIndex; i++) {
            if (nums[i]>nums[maxIndex]){
                maxIndex=i;
            }
        }
        TreeNode root= new TreeNode(nums[maxIndex]);
        root.left=constructMaximumBinaryTree1(nums,leftIndex,maxIndex);
        root.right=constructMaximumBinaryTree1(nums,maxIndex+1,rightIndex);
        return root;
    }
// 思路正确，但是46和47行调用了Arrays.copyOfRange()，本质上还是使用了循环，导致时间复杂度提高
//    public TreeNode constructMaximumBinaryTree(int[] nums) {
//        if(nums.length==1){
//            new TreeNode(nums[0]);
//        }
//        int maxIndex=0;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i]>nums[maxIndex]){
//                maxIndex=i;
//            }
//        }
//        TreeNode root=new TreeNode(nums[maxIndex]);
//        if (maxIndex>0){
//            root.left=constructMaximumBinaryTree(Arrays.copyOfRange(nums,0,maxIndex));
//        }
//        if (maxIndex<nums.length-1){
//            root.right=constructMaximumBinaryTree(Arrays.copyOfRange(nums,maxIndex+1,nums.length));
//        }
//
//        return root;
//    }
}
