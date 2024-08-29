public class leetcode_240 {
    public static void main(String[] args) {
        int[][] arr = {{1, 1}};
        System.out.println(searchMatrix(arr, 0));
    }
//从右上角开始遍历更优，还可使用二分法
    public static boolean searchMatrix(int[][] matrix, int target) {

        int x = 0;
        int y = 0;

        while (x < matrix.length && y < matrix[0].length) {

            //横向遍历
            for (int column = y; column < matrix[0].length; column++) {
                if (matrix[x][column] == target)
                    return true;
                if (matrix[x][column] > target) {
                    break;
                }
            }

            //纵向遍历
            for (int row = x; row < matrix.length; row++) {
                if (matrix[row][y] == target)
                    return true;
                if (matrix[row][y] > target)
                    break;
            }

            x++;
            y++;
        }
        if (x<matrix.length){
            for (int column = y-1; column < matrix[0].length; column++) {
                if (matrix[x][column] == target)
                    return true;
                if (matrix[x][column] > target) {
                    break;
                }
            }
        }

        if (y<matrix[0].length){
            for (int row = x-1; row < matrix.length; row++) {
                if (matrix[row][y] == target)
                    return true;
                if (matrix[row][y] > target)
                    break;
            }
        }
        return false;
    }
}
