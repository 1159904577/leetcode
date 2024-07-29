import java.util.Scanner;

public class kama_58 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i]=sc.nextInt()+arr[i-1];
        }
        while (sc.hasNext()){
            int a= sc.nextInt()+1;
            int b= sc.nextInt()+1;
            System.out.println(arr[b]-arr[a-1]);
        }
    }

}
