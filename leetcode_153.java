public class leetcode_153 {
    public static void main(String[] args) {
        String s=" abc def  gh ";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        String str=s.trim();
        int left=str.length()-1;
        int right=str.length()-1;

        StringBuilder sb =new StringBuilder();
        while(left>=0){
            while(left>=0 && str.charAt(left) != ' '){
                left--;
            }

            sb.append(str.substring(left+1,right+1));
            if(left>=0)
                sb.append(" ");

            while(left>=0 && str.charAt(left) == ' '){
                left--;
            }
            right=left;
        }
        return sb.toString();
    }
}
