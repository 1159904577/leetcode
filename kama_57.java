import java.util.Scanner;

public class kama_57 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(paLouTi(n,m));
    }

    public static int paLouTi(int n,int m){

        int[] dp = new int[n+1];

        dp[0]=1;

        //先背包再物品
        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                if (j - i >= 0)
                    dp[j] += dp[j - i];
            }
        }

        return dp[n];

    }
}
