import java.util.Arrays;

public class leetcode_300 {
    public static void main(String[] args) {

    }

    public static int lengthOfLIS(int[] nums) {
        if (nums.length<=1)
            return nums.length;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res=1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j]<nums[i]){
                    dp[i]= Math.max(dp[j]+1,dp[i]);
                }
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
