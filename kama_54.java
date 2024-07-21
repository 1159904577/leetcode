import java.util.Scanner;

public class kama_54 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(chartonum(s));
    }

    public static String chartonum(String s){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>='a'&& s.charAt(i)<= 'z'){
                sb.append(s.charAt(i));
            }else{
                sb.append("number");
            }
        }
        return sb.toString();
    }
}
