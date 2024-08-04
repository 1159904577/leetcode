public class leetcode_151 {
    public static void main(String[] args) {

    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();

        int start = s.length() - 1;

        while (start >= 0 && s.charAt(start) == ' ') {
            start--;
        }
        int end = start+1;
        while (start >= 0) {

            while (start >= 0 && s.charAt(start) != ' ') {
                start--;
            }
            sb.append(s.substring(start + 1, end));

            sb.append(' ');

            while (start >= 0 && s.charAt(start) == ' ') {
                start--;
            }
            end = start + 1;
        }

        sb.delete(sb.length()-1,sb.length());

        return sb.toString();
    }
}
