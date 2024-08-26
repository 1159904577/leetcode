public class leetcode_48 {

    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        rotate(arr);
    }
    public static void rotate(int[][] matrix) {

        int n = matrix.length;
        int[] arr = new int[n];
        int loop = n / 2;

        int left = 0;
        int right = n - 1;


        while (loop > 0) {
            //保存上行数据
            for (int i = left; i <= right; i++) {
                arr[i] = matrix[left][i];
                System.out.println(arr[i]);
            }
            System.out.println("--------------");
            //左---->上
            for (int i = left, j = right; i <= right; i++, j--) {
                matrix[left][j] = matrix[i][left];
                System.out.println(matrix[left][j]);
            }
            System.out.println("--------------");
            //下---->左
            for (int i = left; i <= right; i++) {
                matrix[i][left] = matrix[right][i];
                System.out.println(matrix[i][left]);
            }
            System.out.println("--------------");
            //右----->下
            for (int i = left, j = right; i <= right; i++, j--) {
                matrix[right][i] = matrix[j][right];
                System.out.println(matrix[right][i]);
            }
            System.out.println("--------------");
            //上（arr）----->右
            for (int i = left; i <= right; i++) {
                matrix[i][right] = arr[i];
                System.out.println(matrix[i][right]);
            }
            System.out.println("--------------");
            left++;
            right--;
            loop--;
        }

    }
}
