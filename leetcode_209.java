import java.util.MissingFormatArgumentException;

public class leetcode_209 {

    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3,};
        System.out.println(minSubArrayLen(7,arr));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int left=0;
        int minCount=Integer.MAX_VALUE;
        int sum=0;
        for (int right = 0; right < nums.length; right++) {
            sum+=nums[right];
            while(sum>=target){
                minCount=Math.min(minCount,right-left+1);
                sum-=nums[left++];
            }
        }
//        for (int i = slow; i < nums.length; i++) {
//            int sum=0;
//            int count=0;
//            int fast=i;
//            while (fast<nums.length && sum<target){
//                sum+=nums[fast];
//                fast++;
//                count++;
//            }
//            if (sum>=target){
//                minCount=Math.min(minCount,count);
//            }
//        }

        return minCount==Integer.MAX_VALUE?0:minCount;
    }
}
