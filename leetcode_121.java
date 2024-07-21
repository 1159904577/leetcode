public class leetcode_121 {
    public static void main(String[] args) {

    }

    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];

        //0不持有股票，1持有股票
        dp[0][0]=0;
        dp[0][1]=-prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0]=Math.max(dp[i-1][1]+prices[i],dp[i-1][0]);
            dp[i][1]=Math.max(dp[i-1][1],-prices[i]);
        }

        return dp[prices.length-1][0];

    }

    //一维数组
    public static int maxProfit1(int[] prices) {
        int[] dp = new int[2];
        dp[0]=0;
        dp[1]=-prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[0]=Math.max(dp[0],dp[1]+prices[i]);
            dp[1]=Math.max(-prices[i],dp[1]);
        }
        return dp[0];
    }
}
