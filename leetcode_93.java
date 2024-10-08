import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode_93 {
    public static void main(String[] args) {

    }


    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder(s);
        backtracking(sb, 0, 0);
        return result;
    }


    public void backtracking(StringBuilder sb, int startIndex, int dotCount) {
        if (dotCount == 3) {
            if (isValid(sb, startIndex, sb.length() - 1)) {
                result.add(sb.toString());
            }
            return;
        }

        for (int i = startIndex; i < sb.length(); i++) {
            if (isValid(sb, startIndex, i)) {
                sb.insert(i + 1, '.');
                backtracking(sb, i + 2, dotCount + 1);
                sb.deleteCharAt(i + 1);
            } else
                break;
        }
    }

    private boolean isValid(StringBuilder s, int start, int end) {
        if (start > end)
            return false;
        if (s.charAt(start) == '0' && start != end)
            return false;
        int num = 0;
        for (int i = start; i <= end; i++) {
            int digit = s.charAt(i) - '0';
            num = num * 10 + digit;
            if (num > 255)
                return false;
        }
        return true;
    }


//    List<String> result = new ArrayList<>();
//    public List<String> restoreIpAddresses(String s) {
//        StringBuilder sb = new StringBuilder(s);
//        backTracking(sb, 0, 0);
//        return result;
//    }
//    private void backTracking(StringBuilder s, int startIndex, int dotCount){
//        if(dotCount == 3){
//            if(isValid(s, startIndex, s.length() - 1)){
//                result.add(s.toString());
//            }
//            return;
//        }
//        for(int i = startIndex; i < s.length(); i++){
//            if(isValid(s, startIndex, i)){
//                s.insert(i + 1, '.');
//                backTracking(s, i + 2, dotCount + 1);
//                s.deleteCharAt(i + 1);
//            }else{
//                break;
//            }
//        }
//    }
//    //[start, end]
//    private boolean isValid(StringBuilder s, int start, int end){
//        if(start > end)
//            return false;
//        if(s.charAt(start) == '0' && start != end)
//            return false;
//        int num = 0;
//        for(int i = start; i <= end; i++){
//            int digit = s.charAt(i) - '0';
//            num = num * 10 + digit;
//            if(num > 255)
//                return false;
//        }
//        return true;
//    }
}
