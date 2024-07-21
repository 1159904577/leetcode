import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_18 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        //排序
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            //nums[i]>target时，直接返回res
            //为什么需要nums[i]>=0
            //answer：nums[]={-3,-2,-1,0,1,2,3}      target=-4
            //此时最小的nums[0]=-3>-4,但是nums[0]+nums[2]=-4
            //所以要求nums[i]>0
            if(nums[i]>target && nums[i]>=0){
                return res;
            }
            //第一层遍历有重复的nums[i]直接进入下次循环
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            for(int j=i+1;j<nums.length;j++){
                //第二层遍历时，nums[i]+nums[j]>target && nums[i]>=0直接退出循环
                if(nums[i]+nums[j]>target && nums[i]>=0){
                    break;
                }

                //第二层遍历有重复的nums[j]直接进入下次循环
                if(j>i+1 && nums[j]==nums[j-1]){
                    continue;
                }
                int left=j+1;
                int right=nums.length-1;
                while(left<right){
                    if(nums[i]+nums[j]+nums[left]+nums[right]==target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while(left<right && nums[left]==nums[left+1]){
                            left++;
                        }
                        while(left<right && nums[right]==nums[right-1]){
                            right--;
                        }
                        left++;
                        right--;
                    }else if(nums[i]+nums[j]+nums[left]+nums[right]<target){
                        left++;
                    }else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
}
