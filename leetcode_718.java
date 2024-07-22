public class leetcode_718 {
    public static void main(String[] args) {

    }
//一维dp
    public int findLength(int[] nums1, int[] nums2) {

        int[] dp = new int[nums2.length+1];

        int res = 0;

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = nums2.length; j > 0; j--){
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[j] = dp[j - 1] + 1;
                }else {
                    dp[j]=0;
                }
                res = Math.max(res,dp[j]);
            }
        }
        return res;
    }

    //二维dp
    public int findLength1(int[] nums1, int[] nums2) {


        //dp[i][j]表示以nums1的i-1，nums2的j-1为结尾的最长公共子数组长度
        int[][] dp = new int[nums1.length+1][nums2.length+1];

        int res = 0;

        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                res = Math.max(res,dp[i][j]);
            }
        }
        return res;
    }
}
