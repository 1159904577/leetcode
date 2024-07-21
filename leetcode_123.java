public class leetcode_123 {
    public static void main(String[] args) {

    }

    public static int maxProfit(int[] prices) {
        if (prices.length == 0){
            return 0;
        }

        int[][] dp = new int[prices.length][5];
        dp[0][1]=-prices[0];
        dp[0][3]=-prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
            dp[i][2]=Math.max(dp[i-1][2],dp[i-1][1]+prices[i]);
            dp[i][3]=Math.max(dp[i-1][3],dp[i-1][2]-prices[i]);
            dp[i][4]=Math.max(dp[i-1][4],dp[i-1][3]+prices[i]);
        }

        return dp[prices.length-1][4];
    }

    public static int maxProfit1(int[] prices) {
        if (prices.length == 0){
            return 0;
        }

        int[] dp = new int[5];
        dp[1]=-prices[0];
        dp[3]=-prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[1]=Math.max(-prices[i],dp[1]);
            dp[2]=Math.max(dp[1]+prices[i],dp[2]);
            dp[3]=Math.max(dp[2]-prices[i],dp[3]);
            dp[4]=Math.max(dp[3]+prices[i],dp[4]);
        }

        return dp[4];
    }
}
