import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class leetcode_39 {
    public static void main(String[] args) {

    }


    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates,int target){
        Arrays.sort(candidates);
        backtracking(candidates,target,0,0);
        return result;
    }

    LinkedList<Integer> list = new LinkedList<>();
    //之所以定义int index
    //当n叉树下一层取数的时候应该从大于等于自身开始取
    //否增会有重复的组合
    private void backtracking(int[] candidates,int target,int sum,int index){
        if (sum==target){
            result.add(new ArrayList<>(list));
            return;
        }

//        if (sum>target){
//            return;
//        }

        for (int i = index; i < candidates.length; i++) {
            // 剪枝优化
            //在循环开始的时候判断sum是否大于target，这样可以减少递归
            if (sum+candidates[i]>target){
                return;
            }
            list.add(candidates[i]);
            sum+=candidates[i];
            backtracking(candidates,target,sum,i);
            sum-=candidates[i];
            list.removeLast();
        }
    }
}
