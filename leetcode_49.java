import java.util.*;


public class leetcode_49 {
    public static void main(String[] args) {
        String[] strs = {"ac","c"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ll = new ArrayList<>();

        boolean[] flag = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            if (flag[i]==true){
                continue;
            }
            List<String> l = new LinkedList<>();
            Set<Character> set = new HashSet<>();
            String str = strs[i];
            l.add(str);
            if (str.length()==0){
                set.add(null);
            }else{
                for (int j = 0; j < str.length(); j++) {
                    set.add(str.charAt(j));
                }
            }
            //第二个指针
            for (int j = i+1; j < strs.length; j++) {
                //如果已经放入过l，则直接continue
                if (flag[j]==true){
                    continue;
                }
                String tmp = strs[j];
                if (tmp.length()==0 && set.contains(null)){
                    l.add(tmp);
                    flag[j]=true;
                    continue;
                }
                //判断是否放入l
                for (int k = 0; k < tmp.length(); k++) {
                    if (!set.contains(tmp.charAt(k))){
                        break;
                    }
                    if (set.contains(tmp.charAt(k)) && k==tmp.length()-1){
                        l.add(tmp);
                        flag[j]=true;
                    }
                }

            }
            ll.add(new ArrayList<>(l));
        }
        return ll;
    }
}
