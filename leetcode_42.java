import java.util.Deque;
import java.util.LinkedList;

public class leetcode_42 {
    public int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        int sum=0;
        //从该下标下一个元素开始遍历
        for (int i = 1; i < height.length; i++) {
            //当前元素小于栈顶元素时
            if (height[i] < height[stack.peek()]) {
                stack.push(i);
            }else if (height[i] == height[stack.peek()] ){
                stack.pop();
                stack.push(i);
            }
            else {
                while (!stack.isEmpty() && height[i]>height[stack.peek()]){
                    int mid = stack.pop();

                    if (!stack.isEmpty()){
                        int left = stack.peek();
                        int h=Math.min(height[left],height[i])-height[mid];
                        int w=i-left-1;
                        int area=h*w;
                        if (area>0)
                            sum+=area;
                    }
                }
                stack.push(i);

            }
        }
        return sum;
    }
}
