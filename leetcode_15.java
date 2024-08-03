import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_15 {
    public static void main(String[] args) {
        int[] nums={-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //排序
        //好处是每次循环只可能有一种情况nums[i]+nums[j]+nums[k]==0   xxxxxx
        //当发现三元组和为0时，直接进入下一次循环                     xxxxxx
        //nums[i]+nums[j]+nums[k]==0，j和k可能有不同的取值
        //只有第一层遍历时，nums[i]与nums[i-1]相同时才可continue
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            //发现三元组的第一个元素大于0时直接return
            if(nums[i]>0){
                return res;
            }
            //当相邻元素相同时，直接进入下一次循环
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            //left------k
            int left=i+1;
            //right-----j
            int right=nums.length-1;
            while(left<right){
                if(nums[i]+nums[left]+nums[right]==0){
                    res.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //当nums[left]与nums[left+1]相同时，left++
                    while(right>left&&nums[left]==nums[left+1]){
                        left++;
                    }
                    //当nums[right]与nums[right-1]相同时，right--
                    while(right>left&&nums[right]==nums[right-1]){
                        right--;
                    }

                    right--;
                    left++;
                }else if(nums[i]+nums[left]+nums[right]<0){
                    left++;
                }else {
                    right--;
                }
            }
        }
        return res;
    }
}
