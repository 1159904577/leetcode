import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.HashMap;

public class leetcode_3 {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        HashMap<Character,Integer> hashMap = new HashMap<>();
        int res=1;
        int[] dp = new int[s.length()];
        hashMap.put(s.charAt(0),0);
        dp[0]=1;
        for (int i = 1; i < s.length(); i++) {
            int j=hashMap.getOrDefault(s.charAt(i),-1);
            hashMap.put(s.charAt(i),i);
            if (dp[i-1]<i-j){
                dp[i]=dp[i-1]+1;
            }else{
                dp[i]=i-j;
            }
            res=Math.max(res,dp[i]);
        }

        return res;
    }
}
