public class leetcode_704 {
    public static void main(String[] args) {

    }

    public int search(int[] nums, int target) {

        int left=0;
        int right=nums.length-1;

        while (left<=right){
            int mid = (left+right)>>1;
            if (nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                left = mid +1;
            }else {
                right = mid -1;
            }
        }

        return -1;

    }
}
