import jdk.nashorn.internal.ir.annotations.Ignore;

public class leetcode_416 {
    public static void main(String[] args) {
        int num[] = {1, 5, 11, 5};
        canPartition(num);

    }
    public static boolean canPartition(int[] nums) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }

        if (sum%2==1){
            return false;
        }

        int bagSize = sum/2;
        int wupin=nums.length;

        boolean[][] dp = new boolean[wupin][bagSize+1];

        if (nums[0]<=bagSize){
            dp[0][nums[0]]=true;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                dp[i][j]=dp[i-1][j];
                if (nums[i]==j){
                    dp[i][nums[i]]=true;
                    continue;
                }
                if (nums[i]<j){
                    dp[i][j]=dp[i-1][j] || dp[i-1][j-nums[i]];
                }
            }
        }

        return dp[wupin-1][bagSize];
    }
    public static boolean canPartition1(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }

        int bagSize = sum / 2;
        boolean[][] dp = new boolean[len][bagSize + 1];

        if (nums[0] <= bagSize)
            dp[0][nums[0]] = true;

        for (int i = 1; i < len; i++) {
            for (int j = 1; j < bagSize + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i] == j) {
                    dp[i][nums[i]] = true;
                    continue;
                }
                if (nums[i]<j){
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                }

            }
        }

        return dp[len-1][bagSize];
    }
}
