public class leetcode_322 {
    public static void main(String[] args) {

    }

    public static int coinChange(int[] coins, int amount) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[amount + 1];
        //初始化dp数组为最大值
        for (int j = 0; j < dp.length; j++) {
            dp[j] = max;
        }
        for (int i = 0; i < coins.length ; i++) {
            for (int j = coins[i]; j < amount; j++) {
                if (dp[i - coins[j]] != max) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount];
    }
}
