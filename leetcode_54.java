import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class leetcode_54 {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        List<Integer> l =spiralOrder(arr);
        for (Integer integer:l){
            System.out.print(integer+" ");

        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        if (n==1){
            for (int i = 0; i < m; i++) {
                list.add(matrix[i][0]);
            }
            return list;
        }

        if (m==1){
            for (int i = 0; i < n; i++) {
                list.add(matrix[0][i]);
            }
            return list;
        }

        int you=0;
        int xia=n-1;
        int zuo=m-1;
        int shang=0;


        int count=m/2;
        int index=m%2;
        while (count>0){

            for (int i = you; i < xia; i++) {
                list.add(matrix[you][i]);
            }

            for (int i = you; i < zuo; i++) {
                list.add(matrix[i][xia]);
            }

            for (int i = xia; i > shang; i--) {
                list.add(matrix[zuo][i]);
            }

            for (int i = zuo; i > shang; i--) {
                list.add(matrix[i][shang]);
            }

            you++;
            xia--;
            zuo--;
            shang++;
            count--;

        }

        if (index==1){
            for (int i = you; i <= xia; i++) {
                list.add(matrix[you][i]);
            }
        }

        return list;
    }
}
