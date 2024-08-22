public class leetcode_647 {
    public static void main(String[] args) {

    }

    public int countSubstrings1(String s) {
        int count = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = s.length()-1; i >=0 ; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j-i<=1){
                        count++;
                        dp[i][j] = true;
                    }else if(dp[i+1][j-1]){
                        dp[i][j] = dp[i+1][j-1];
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
