public class leetcode_977 {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int left =0;
        int right=nums.length-1;

        for (int i = right; i >=0; i--) {
            if(nums[left]*nums[left]<=nums[right]*nums[right]){
                res[i]=nums[right]*nums[right];
                right--;
            }else {
                res[i]=nums[left]*nums[left];
                left++;
            }
        }

        return res;
    }
}
