import java.util.Arrays;

public class leetcode_128 {
    public int longestConsecutive(int[] nums) {

        if (nums.length<=1){
            return nums.length;
        }

        Arrays.sort(nums);
        int res=1;
        int count=1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]==nums[i-1]+1){
                count++;
            }else if(nums[i]==nums[i-1]){
                continue;
            }else {
                count=1;
            }

            res=Math.max(res,count);
        }

        return res;
    }
}
