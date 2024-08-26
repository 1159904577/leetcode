import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class leetcode_56 {

    public static void main(String[] args) {
        int[][] arr = {{15, 18}, {1, 3}, {2, 6}, {8, 10}};

        Arrays.sort(arr, new cmp());

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();


        }
    }


    public static int[][] merge(int[][] intervals) {

        if (intervals.length==1){
            return intervals;
        }
        //用size判断最终剩余几个数组
        int size = intervals.length;
        List<int[]> l = new LinkedList<>();
        Arrays.sort(intervals,new cmp());
        int left=0;
        int right=1;
        while (left<intervals.length){
            int[] arr = intervals[left];
            while (right<intervals.length && arr[1]>=intervals[right][0]){
                if (arr[1]<intervals[right][1]){
                    arr[1]=intervals[right][1];
                }
                size--;
                right++;
            }
            l.add(arr);
            left=right;
        }
        int[][] res = new int[size][2];
        return l.toArray(res);
    }
}

class cmp implements Comparator<int[]> {
    @Override
    public int compare(int[] o1, int[] o2) {
        return o1[0] - o2[0];
    }
}


