import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode_76 {
    public static void main(String[] args) {

    }

    public String minWindow(String s, String t) {
        Map<Character,Integer> need = new HashMap<>();
        Map<Character,Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            need.put(t.charAt(i),need.getOrDefault(t.charAt(i),0)+1);
        }
        // 窗口的左右边界
        int left=0;
        int right=0;

        // 已经匹配上的字符数量
        int valid=0;

        // 最小窗口的起始位置和长度
        int start=0;
        int minLen=Integer.MAX_VALUE;

        while (right<s.length()){
            char r=s.charAt(right);
            right++;
            //如果need中有该元素，则put进window
            if (need.containsKey(r)){
                window.put(r,window.getOrDefault(r,0)+1);
                //当need中该元素数量与window中该元素数量相同时，valid++
                if (window.get(r).equals(need.get(r))){
                    valid++;
                }
            }
            //此时，证明window中有了完整的t
            while (valid==need.size()){
                if (right-left<minLen){
                    minLen=right-left;
                    start=left;
                }

                char l=s.charAt(left);
                if (window.containsKey(l)){
                    window.put(l,window.get(l)-1);
                    if (window.get(l)<need.get(l)){
                        valid--;
                    }
                }
                left++;
            }
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(start,start+minLen);
    }
}
