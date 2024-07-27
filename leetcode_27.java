public class leetcode_27 {
    public static void main(String args[]){
        int[] nums ={1,2,1,1};
        int val=1;
        System.out.println(remove(nums,1));
    }

    public static int remove(int[] nums,int val){
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if(nums[fastIndex]==val){
                continue;
            }
            nums[slowIndex++]=nums[fastIndex];
        }
        return slowIndex;
    }

    public static int remove1(int[] nums,int val){
        int slowIndex=0;
        for(int fastIndex=0;fastIndex<nums.length;fastIndex++){
            if(nums[fastIndex]!=val) {
                nums[slowIndex++]=nums[fastIndex];
            }
        }
        for(int k=0;k<slowIndex;k++){
            System.out.println(nums[k]);
        }

        return slowIndex;
    }
}
