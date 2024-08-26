import com.sun.org.apache.xerces.internal.impl.dv.dtd.NMTOKENDatatypeValidator;

public class leetcode_189 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        rotate(arr,3);
    }
    public static void rotate(int[] nums, int k) {

        if (nums.length==1){
            return;
        }

        if (nums.length<k){
            k=k%nums.length;
        }

        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i]=nums[nums.length-k+i];
            System.out.println(arr[i]);
        }
        System.out.println("-----------");

        for (int i = nums.length-k-1;i>=0 ;i--) {
            nums[i+k]=nums[i];
            System.out.println(nums[i+k]);
        }

        System.out.println("-----------");
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
            System.out.println(nums[i]);
        }
    }
}

