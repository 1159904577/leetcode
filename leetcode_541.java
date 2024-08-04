import com.sun.media.sound.RIFFInvalidDataException;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.util.Arrays;

public class leetcode_541 {
    public String reverseStr(String s,int k){

        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i+=2*k) {
            int left = i;
            int right = 0;
            if (i+k<=s.length()){
                right = i+k-1;
            }else {
                right = s.length()-1;
            }
            while (left< right){
                char tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;

                left++;
                right--;
            }

        }

        return new String(arr);
    }
}
