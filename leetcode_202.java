import java.util.HashSet;
import java.util.Set;

public class leetcode_202 {
    public static void main(String[] args) {

    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int tmp=n;
        while (true) {

            tmp = pingfang(tmp);
            if (set.contains(tmp)){
                return false;
            }
            if (tmp==1){
                return true;
            }
            set.add(tmp);
        }
    }

    public int pingfang(int n){
        int sum=0;
        while (n>0){
            sum+=(n%10)*(n%10);
            n=n/10;
        }
        return sum;
    }
}
