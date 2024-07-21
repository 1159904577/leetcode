import java.util.Arrays;
import java.util.Scanner;

public class kama_46 {
    public static void main(String[] args) {
//        int[] weight = {1,3,4};
//        int[] value = {15,20,30};
//        int bagSize = 4;
//        System.out.println(WeightBagProblem(weight,value,bagSize));
//        System.out.println(WeightBag(weight,value,bagSize));
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int bagSize = sc.nextInt();

        int[] weight = new int[M];
        int[] value = new int[M];

        for (int i = 0; i < M; i++) {
            weight[i] = sc.nextInt();
        }

        for (int i = 0; i < M; i++) {
            value[i] = sc.nextInt();
        }
        System.out.println(WeightBag(weight, value, bagSize));
    }


    public static int WeightBagProblem(int[] weight, int[] value, int bagSize) {
        int[][] dp = new int[weight.length][bagSize + 1];

        //初始化
        for (int j = weight[0]; j < bagSize + 1; j++) {
            if (j <= bagSize)
                dp[0][j] = value[0];
        }

        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j < bagSize + 1; j++) {
                if (j < weight[i])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
            }
        }
        // 打印dp数组
        for (int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }

        return dp[weight.length - 1][bagSize];
    }

    public static int WeightBag(int[] weight, int[] value, int bagSize) {
        int[][] dp = new int[weight.length][bagSize + 1];

        for (int j = 1; j < bagSize + 1; j++) {
            if (weight[0] <= j) {
                dp[0][j] = value[0];
            }
        }

        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j < bagSize + 1; j++) {
                if (weight[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }

        for (int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }
        return dp[weight.length - 1][bagSize];
    }


    //滚动数组
    public static int gunDong(int[] weight, int[] value, int bagSize){
        int[] dp = new int[bagSize+1];

        for (int i = 0; i < weight.length; i++) {
            for (int j = bagSize; j>=weight[i]; j--) {
                dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
        return dp[bagSize];
    }
}
