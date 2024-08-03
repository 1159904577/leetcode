import java.util.HashMap;
import java.util.Map;

public class leetcode_1 {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] nums,int target){

        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])){
                int[] arr = new int[2];
                arr[0]=map.get(target-nums[i]);
                arr[1]=i;
                return arr;
            }
            map.put(nums[i],i);
        }
        return null;
    }

}
