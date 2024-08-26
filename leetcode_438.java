import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_438 {
    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> res = new ArrayList<>();

        char[] parr = p.toCharArray();
        Arrays.sort(parr);
        String pstr=new String(parr);

        for (int i = 0; i <= s.length()-p.length(); i++) {
            String tmp = s.substring(i,i+p.length());
            if (isYiwei(pstr,tmp)){
                res.add(i);
            }
        }

        return res;
    }

    public static boolean isYiwei(String pstr,String tmp){

        char[] tmparr = tmp.toCharArray();
        Arrays.sort(tmparr);
        String tmpstr = new String(tmparr);

        return tmpstr.equals(pstr);
    }
}
