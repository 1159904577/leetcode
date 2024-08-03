import java.util.HashMap;
import java.util.Map;

public class leetcode_454 {
    public static void main(String[] args) {

    }

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map1 = new HashMap();
//        Map<Integer,Integer> map2 = new HashMap();
        int count=0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int tmp = nums1[i]+nums2[j];
                if (map1.containsKey(tmp)){
                    map1.put(tmp,map1.get(tmp)+1);
                }else {
                    map1.put(tmp,1);
                }

            }
        }
        for (int i = 0; i < nums3.length; i++) {
            for (int j = 0; j < nums4.length; j++) {
                int tmp = 0-nums3[i]-nums4[j];
                if (map1.containsKey(tmp)){
                    count+=map1.get(tmp);
                }
            }
        }

        return count;
    }
}
