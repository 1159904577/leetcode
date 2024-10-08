import javafx.scene.paint.Stop;

import java.util.Stack;

public class leetcode_1049 {
    public static int lastStoneWeightII(int[] stones) {
        int sum=0;
        for (int i = 0; i < stones.length; i++) {
            sum+=stones[i];
        }

        int bagSize=sum/2;
        int len=stones.length;

        int[][] dp = new int[len][bagSize+1];

        for (int j = stones[0]; j <= bagSize; j++) {
            dp[0][j]=stones[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (stones[i]<=j){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-stones[i]]+stones[i]);
                }else {
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return sum-2*dp[stones.length-1][bagSize];
    }



    public static int lastStoneWeightII1(int[] stones) {
        int sum=0;
        for (int stone:stones){
            sum+=stone;
        }

        int target = sum/2;

        int[][] dp = new int[stones.length][target+1];

        for (int j = stones[0];j <= target; j++) {
            dp[0][j]=stones[0];
        }

        for (int i = 1; i < stones.length; i++) {
            for (int j = 1; j < target+1; j++) {
                if (stones[i]<=j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return sum-2*dp[stones.length-1][target];
    }
}
