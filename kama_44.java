import java.util.Scanner;

public class kama_44 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j]=sc.nextInt();
            }
        }

        System.out.println(minDiff(arr));
    }

    public static int minDiff(int[][] arr){
        int min=Integer.MAX_VALUE;
        //遍历所有求sum
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                sum+=arr[i][j];
            }
        }
        //遍历所有行
        int tmp1=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                tmp1+=arr[i][j];
            }
            min=Math.min(min,Math.abs(2*tmp1-sum));
        }
        //遍历所有列
        int tmp2=0;
        for (int j = 0; j < arr[0].length; j++) {
            for (int i = 0; i < arr.length; i++) {
                tmp2+=arr[i][j];
            }
            min=Math.min(min,Math.abs(2*tmp2-sum));
        }

        return min;
    }
}
