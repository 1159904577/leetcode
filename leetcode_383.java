import java.util.HashMap;
import java.util.Map;

public class leetcode_383 {
    public static void main(String[] args) {

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map = new HashMap<>();
        for (char c :ransomNote.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (char c : magazine.toCharArray()){
            if (map.containsKey(c)){
                if (map.get(c)>1){
                    map.put(c,map.get(c)-1);
                }else {
                    map.remove(c);
                }

            }
        }

        return map.isEmpty();
    }
}
