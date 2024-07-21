public class leetcode_494 {
    public static int findTargetSumWays(int[] nums, int target) {


        //将nums分为左右连个集合，左集合全部做加法，右集合全部做减法
        //left-right=target
        //left+right=sum
        //------>left=(target+sum)/2

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum < Math.abs(target)) {
            return 0;
        }
        if ((target + sum) % 2 != 0) {
            return 0;
        }

        int bagSize = (target + sum) / 2;

        int[][] dp = new int[nums.length][bagSize + 1];

        //初始化行
        if (nums[0] <= bagSize) {
            dp[0][nums[0]] = 1;
        }

        //初始化列
        int zeroNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNum++;
            }
            dp[i][0] = (int) Math.pow(2, zeroNum);
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < bagSize + 1; j++) {
                if (nums[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i]];
                }
            }
        }

        return dp[nums.length - 1][bagSize];
    }
}
