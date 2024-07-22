import java.util.List;

public class leetcode_139 {
    public static void main(String[] args) {

    }


    /*
    本题其实我们求的是排列数，为什么呢。 拿 s = "applepenapple", wordDict = ["apple", "pen"] 举例。

    "apple", "pen" 是物品，那么我们要求 物品的组合一定是 "apple" + "pen" + "apple" 才能组成 "applepenapple"。

    "apple" + "apple" + "pen" 或者 "pen" + "apple" + "apple" 是不可以的，那么我们就是强调物品之间顺序
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];

        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word:wordDict){
                int len = word.length();
                if (i>len && dp[i-len] && word.equals(s.substring(i-len,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
