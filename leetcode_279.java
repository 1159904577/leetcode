public class leetcode_279 {
    public static void main(String[] args) {

    }

    public static int numSquares(int n) {

        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        //和为0时，组合个数为0
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = max;
        }

        //物品
        //遍历时从1开始
        for (int i = 1; i*i<=n; i++) {
            //背包
            for (int j = i*i; j <= n; j++) {
                if (dp[j-i*i]!=max){
                    dp[j] = Math.min(dp[j], dp[j-i*i]+1);
                }
            }
        }
        return dp[n];
    }
}
