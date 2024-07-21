import java.util.Scanner;

public class kama_52 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int V = sc.nextInt();
        int[] weight= new int[N];
        int[] value= new int[N];
        for (int i = 0; i < N; i++) {
            weight[i]=sc.nextInt();
            value[i]=sc.nextInt();
        }
        System.out.println(wanQuan(N, V, weight, value));
    }

    public static int wanQuan(int N,int V,int[] weight,int[] value){
        int[] dp = new int[V+1];

//        for (int j = weight[0]; j <= V; j++) {
//            dp[j]= weight[0];
//        }

        for (int i = 0; i < N; i++) {
            for (int j = weight[i]; j <= V; j++) {
                dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }

        return dp[V];
    }

}
