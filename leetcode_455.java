import java.util.Arrays;

public class leetcode_455 {
    public static void main(String[] args) {

    }

    public int findContentChildren(int[] g,int[] s){
        int max=0;
        Arrays.sort(g);
        Arrays.sort(s);
        for (int i = 0, j=0; i < g.length && j<s.length;) {
            if (s[j]>=g[i]){
                max++;
                i++;
            }
            j++;
        }

        return max;
    }
}
