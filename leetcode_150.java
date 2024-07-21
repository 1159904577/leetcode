import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class leetcode_150 {
    public static void main(String[] args) {

    }

    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack =new LinkedList<>();
        int a;
        int b;

        for (String s:tokens) {
            if(s.equals("+")){
                stack.push(stack.pop()+stack.pop());
            }else if (s.equals("-")){
                stack.push(-stack.pop()+stack.pop());
            }else if (s.equals("*")){
                stack.push(stack.pop()*stack.pop());
            }else if (s.equals("/")){
                b=stack.pop();
                a=stack.pop();
                stack.push(a/b);
            }else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.peek();
    }
}
