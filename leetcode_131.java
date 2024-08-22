import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode_131 {
    public static void main(String[] args) {

    }

    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s){
        backtracking(s,0);
        return res;
    }
    LinkedList<String> list = new LinkedList<>();
    public void backtracking(String s,int index){

        if (index>=s.length()){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isHuiwen(s,index,i)){
                String str = s.substring(index,i+1);
                list.add(str);
            }else {
                continue;
            }
            backtracking(s,i+1);
            list.removeLast();
        }
    }

    public boolean isHuiwen(String s,int left ,int right){

        while (left<right){
            if (s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


//    List<List<String>> res = new ArrayList<>();
//    public List<List<String>> partition(String s){
//        backtracking(s,0);
//        return res;
//    }
//
//    LinkedList<String> list = new LinkedList<>();
//    private void backtracking(String s,int index){
//        if (index>=s.length()){
//            res.add(new ArrayList<>(list));
//            return;
//        }
//
//        for (int i=index;i<s.length();i++){
//            if (isPalindrome(s,index,i)){
//                String str=s.substring(index,i+1);
//                list.addLast(str);
//            }else {
//                continue;
//            }
//            backtracking(s,i+1);
//            list.removeLast();
//        }
//    }
//
//    //判断是否是回文串
//    private boolean isPalindrome(String s, int startIndex, int end) {
//        for (int i = startIndex, j = end; i < j; i++, j--) {
//            if (s.charAt(i) != s.charAt(j)) {
//                return false;
//            }
//        }
//        return true;
//    }
}
