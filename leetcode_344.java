import java.util.Scanner;

public class leetcode_344 {
    public static void main(String args[]){

        char[] s = {'a','b','c','d'};
        reverseStr(s);
        for(int i=0;i<s.length;i++){
            System.out.println(s[i]);
        }
    }

    public static char[] reverseStr(char[] s){
        int left=0;
        int right=s.length-1;
        while(left<right){
            s[left]^=s[right];
            s[right]^=s[left];
            s[left++]^=s[right--];
        }
        return s;
    }
}
