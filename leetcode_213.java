public class leetcode_213 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,1,2,3,4,5};
        System.out.println(rob(nums));

    }

    public static int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        if (len == 1)
            return nums[0];
        //要不不选尾元素，要不不选首元素
        return Math.max(robAction(nums, 0, len - 1), robAction(nums, 1, len));
    }

    public static int robAction(int[] nums, int start, int end) {
        int x = 0, y = 0, z = 0;
        for (int i = start; i < end; i++) {
            y = z;
            z = Math.max(y, x + nums[i]);
            x = y;
        }
        return z;
    }
}
