public class leetcode_188 {
    public static void main(String[] args) {

    }

    public static int maxProfit(int k, int[] prices) {
        if (prices.length == 0){
            return 0;
        }

        int[] dp = new int[2*k+1];
        for (int i = 1; i <=2*k-1; i+=2) {
            dp[i]=-prices[0];
        }

        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= 2*k; j++) {
                if (j%2==1){
                    dp[j]=Math.max(dp[j-1]-prices[i],dp[j]);
                }else{
                    dp[j]=Math.max(dp[j-1]+prices[i],dp[j]);
                }
            }
        }

        return dp[2*k];
    }
}
