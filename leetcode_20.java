import java.util.*;

public class leetcode_20 {
    public static void main(String[] args) {

    }

    public static boolean isValid(String s) {
//        Stack<Character> stack = new Stack<>();
        Deque<Character> deque = new LinkedList<>();
//        ***碰到左括号，就把相应的右括号入栈
//        ***用这种方法避免了用map
//        Map<Character,Character> map =new HashMap<>();
//        map.put('(',')');
//        map.put('{','}');
//        map.put('[',']');
//        for(int i=0;i<s.length();i++){
//            if(stack.isEmpty()){
//                stack.push(s.charAt(i));
//            }else{
//                if(map.get(stack.peek())!=null&&map.get(stack.peek())==s.charAt(i)){
//                    stack.pop();
//                }
//                else{
//                    stack.push(s.charAt(i));
//                }
//            }
//        }
        for (int i = 0; i < s.length(); i++) {
            char ch=s.charAt(i);
            if(ch=='('){
                deque.push(')');
            }else if(ch=='['){
                deque.push(']');
            }else if(ch=='{'){
                deque.push('}');
            }else if(deque.isEmpty() || deque.peek()!=ch){
                return false;
            }else {
                deque.pop();
            }
        }
        return deque.isEmpty();
    }
}
