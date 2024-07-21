import java.time.Period;

public class leetcode_122 {
    public static void main(String[] args) {

    }

    //贪心
    public int maxProfit(int[] prices) {

        int sum=0;
        for (int i = 1; i < prices.length; i++) {
            sum+=Math.max(prices[i]-prices[i-1],0);
        }
        return sum;
    }

    //动态规划--二维数组
    public int maxProfit1(int[] prices) {
        int[][] dp = new int[prices.length][2];

        dp[0][0]=0;
        dp[0][1]=-prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0]=Math.max(dp[i-1][1]+prices[i],dp[i-1][0]);
            dp[i][1]=Math.max(dp[i-1][0]-prices[i],dp[i-1][1]);
        }

        return dp[prices.length-1][0];
    }

    //动态规划--一维数组
    public int maxProfit2(int[] prices) {
        int[] dp = new int[2];

        dp[0]=0;
        dp[1]=-prices[0];

        int temp;
        for (int i = 1; i < prices.length; i++) {
            temp=dp[0];
            dp[0]=Math.max(dp[1]+prices[i],dp[0]);
            dp[1]=Math.max(temp-prices[i],dp[1]);
        }

        return dp[0];
    }
}
