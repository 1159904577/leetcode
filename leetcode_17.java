import java.util.ArrayList;
import java.util.List;

public class leetcode_17 {
    public static void main(String[] args) {

    }

    List<String> list = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length()==0 || digits==null){
            return list;
        }
        String[] numString ={"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtracking(digits,0,numString);
        return list;
    }

    StringBuilder sb =new StringBuilder();

    private void backtracking(String digits,int num ,String[] numString){
        if (num==digits.length()){
            list.add(sb.toString());
            return;
        }
        String str=numString[digits.charAt(num)-'0'];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backtracking(digits,num+1,numString);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
