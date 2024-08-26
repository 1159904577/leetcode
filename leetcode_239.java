import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;


public class leetcode_239 {
    public static void main(String[] args) {

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int[] arr = new int[nums.length-k+1];

        Deque<Integer> deque = new LinkedList<>();

        int index=0;

        for (int i = 0; i < nums.length; i++) {

            if (!deque.isEmpty() && i-deque.peekFirst()>=k){
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[i]>=nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);

            if (i>=k-1){
                arr[index++]=nums[deque.peekFirst()];
            }
        }

        return arr;
    }

    public static int[] maxSlidingWindow1(int[] nums, int k) {

        int length = nums.length;
        int[] arr = new int[length + 1 - k];
        int index = 0;
        //双向队列用来存储元素下标，元素的值可以通过数组找到
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < length; i++) {
            //当元素超过滑动窗口范围时pop出去
            while (!deque.isEmpty() && deque.peek() <= i - k) {
                deque.poll();
            }
            //当小于新加入元素时poplast
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);
            // 因为单调，当i增长到符合第一个k范围的时候，每滑动一步都将队列头节点放入结果就行了
            if (i >= k - 1) {
                arr[index++] = nums[deque.peek()];
            }
        }
        return arr;
    }


    public static int[] maxSlidingWindow2(int[] nums, int k) {

        int[] arr = new int[nums.length - k + 1];
        int index = 0;
        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peek() + k <= i) {
                deque.poll();
            }
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offer(i);

            if (i >= k - 1) {
                arr[index++] = nums[deque.peek()];
            }
        }
        return arr;

    }
}
