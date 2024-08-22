import java.util.concurrent.ForkJoinPool;

public class leetcode_392 {
    public static void main(String[] args) {

    }

    public boolean isSubsequence(String s, String t) {
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;
        for (int i = 0; i < t.length(); i ++) {
            for (int j = dp.length - 1; j > 0; j --) {
                if (t.charAt(i) == s.charAt(j - 1)) {
                    dp[j] = dp[j - 1];
                }
            }
        }
        return dp[dp.length - 1];
    }

    public boolean isSubsequence1(String s, String t) {
        if (s.length() == 0)
            return true;
        int start = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(start)) {
                start++;
            }
            if (start == s.length())
                return true;
        }

        return false;
    }
}
