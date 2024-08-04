import java.util.Scanner;

public class leetcode_54 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) <= 'z' && s.charAt(i) >= 'a') {
                sb.append(s.charAt(i));
            } else {
                sb.append("number");
            }
        }

        System.out.println(sb.toString());
    }
}
