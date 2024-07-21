import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class leetcode_40 {
    public static void main(String[] args) {

    }

    List<List<Integer>> result = new ArrayList<>();
    boolean[] used;
    int sum=0;
    public List<List<Integer>> combinationSum2(int[] candidates,int target){
        used=new boolean[candidates.length];
        Arrays.fill(used,false);
        Arrays.sort(candidates);
        backtracking(candidates,target,0);
        return result;
    }

    LinkedList<Integer> list = new LinkedList<>();

    private void backtracking(int[] candidates,int target,int index){
        if (sum==target){
            result.add(new ArrayList<>(list));
            //为什么删了return效率更高？？？？？？
            return;
        }

//        if (sum>target){
//            return;
//        }

        for (int i = index; i < candidates.length; i++) {
            // 剪枝优化
            //在循环开始的时候判断sum是否大于target，这样可以减少递归
            if (sum+candidates[i]>target){
                break;
            }

            if (i>0&&candidates[i]==candidates[i-1]&&!used[i-1]){
                continue;
            }

            list.add(candidates[i]);
            sum+=candidates[i];
            used[i]=true;
            backtracking(candidates,target,i+1);
            used[i]=false;
            sum-=candidates[i];
            list.removeLast();
        }
    }
}
