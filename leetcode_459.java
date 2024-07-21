public class leetcode_459 {

    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        String str = s+s;
        String str1=str.substring(1,str.length()-1);
        System.out.println(str1);
        int i=0;
        while(i<=str1.length()-s.length()){
            if(s.equals(str1.substring(i,i+s.length())))
                return true;
            i++;
        }
        return false;
    }
}
