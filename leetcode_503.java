import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class leetcode_503 {
    public static void main(String[] args) {

    }

    public int[] nextGreaterElements(int[] nums) {
        int[] res= new int[nums.length];
        Arrays.fill(res,-1);

        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        for (int i = 1; i < 2*nums.length; i++) {
            if (nums[i%nums.length]<=nums[stack.peek()%nums.length]){
                stack.push(i);
            }else {
                while (!stack.isEmpty() && nums[i%nums.length]>nums[stack.peek()%nums.length]){
                    res[stack.peek()%nums.length]=nums[i%nums.length];
                    stack.pop();
                }
                stack.push(i);
            }
        }

        return res;
    }
}
