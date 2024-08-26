import com.sun.org.apache.xml.internal.dtm.ref.sax2dtm.SAX2DTM2;

import java.util.*;

public class leetcode_73 {

    public static void main(String[] args) {
        int[][] arr = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };
        setZeroes(arr);

    }
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        Deque<Integer> queue1 = new LinkedList<>();
        Deque<Integer> queue2 = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j]==0){
                    queue1.push(i);
                    queue2.push(j);
                }
            }
        }

        while (!queue1.isEmpty()){
            int x=queue1.poll();
            int y=queue2.poll();

            for (int i = 0; i < n; i++) {
                matrix[x][i]=0;
            }
            for (int i = 0; i < m; i++) {
                matrix[i][y]=0;
            }
        }


    }
}
