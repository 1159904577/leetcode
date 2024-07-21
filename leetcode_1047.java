import java.util.Deque;
import java.util.LinkedList;

public class leetcode_1047 {
    public static void main(String[] args) {

    }

    public static String removeDuplicates(String s){

        //***没有双指针快
//        Deque<Character> deque = new LinkedList<>();
//        String res="";
//        for (int i = 0; i < s.length(); i++) {
//            char ch=s.charAt(i);
//            if(deque.isEmpty()){
//                deque.push(ch);
//            }else{
//                if(deque.peek()==ch){
//                    deque.pop();
//                }else {
//                    deque.push(ch);
//                }
//            }
//        }
//        while (!deque.isEmpty()){
//            res=deque.pop()+res;
//        }
//        return res;

        char[] chars= s.toCharArray();
        int fast=0;
        int slow=0;
        while (fast<chars.length){
            chars[slow]=chars[fast];
            if(slow>0 && chars[slow]==chars[slow-1]){
                slow--;
            }else
                slow++;
            fast++;
        }
        return new String(chars,0,slow);
    }

}
