import com.sun.xml.internal.ws.util.xml.XmlUtil;

import java.util.zip.CheckedOutputStream;

public class leetcode_560 {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        System.out.println(subarraySum(arr, 2));
    }

    public static int subarraySum(int[] nums, int k) {
        int count=0;
        int sum=0;
        int index=0;
        for (int i = 0; i < nums.length; i++) {

        }
        return count;
    }

    public static int subarraySum1(int[] nums, int k) {
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            int sum=0;
            for (int j = i; j < nums.length; j++) {
                sum+=nums[j];
                if (sum==k){
                    count++;
                }
            }
        }
        return count;
    }
}
