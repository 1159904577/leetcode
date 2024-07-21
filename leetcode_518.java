import jdk.swing.interop.LightweightContentWrapper;

public class leetcode_518 {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        //初始化dp数组，表示金额为0时只有一种情况，也就是什么都不装
        dp[0]=1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < amount+1; j++) {
                dp[j]=dp[j]+dp[j-coins[i]];
            }
        }

        return dp[amount];
    }
}
