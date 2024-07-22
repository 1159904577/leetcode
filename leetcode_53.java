public class leetcode_53 {
    public static void main(String[] args) {

    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            res=Math.max(res, dp[i]);
        }

        return res;
    }

    public int maxSubArray1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count = count + nums[i];
            max = Math.max(max, count);
            //count置为0，相当于舍弃前面为负的数
            if (count < 0) {
                count = 0;
            }
        }
        return max;
    }
}
