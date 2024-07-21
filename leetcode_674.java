import javax.print.attribute.standard.NumberUp;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.IllegalFormatFlagsException;

public class leetcode_674 {
    public static void main(String[] args) {

    }

    //dp
    public int findLengthOfLCIS(int[] nums) {

        if (nums.length <= 1) {
            return nums.length;
        }

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1]<nums[i])
                dp[i]=dp[i-1]+1;
            res = Math.max(dp[i],res);
        }

        return res;

    }


    //贪心
    public int findLengthOfLCIS1(int[] nums) {

        if (nums.length <= 1) {
            return nums.length;
        }

        int res = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] < nums[i])
                count++;
            else
                count = 1;

            res = Math.max(res, count);
        }

        return res;

    }
}
