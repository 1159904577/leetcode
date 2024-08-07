public class leetcode_55 {
    public static void main(String[] args) {

    }

    public boolean canJump(int[] nums) {
        if (nums.length==1){
            return true;
        }

        int coverage=0;
        for (int i = 0; i <= coverage; i++) {
            coverage=Math.max(coverage,i+nums[i]);
            if (coverage>=nums.length-1){
                return true;
            }
        }
        return false;
    }
}
