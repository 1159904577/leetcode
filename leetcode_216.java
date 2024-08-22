import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode_216 {
    public static void main(String[] args) {

    }

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backTracking(k,n,0,1);
        return result;
    }

    public void backTracking(int k,int n,int sum,int startIndex){
        if (sum>n){
            return;
        }
        if (path.size()==k){
            if (sum==n){
                result.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = startIndex; i <=9-(k-path.size())+1; i++) {
            path.add(i);
            sum+=i;
            backTracking(k,n,sum,i+1);
            path.removeLast();
            sum-=i;
        }

    }



//    List<List<Integer>> result = new ArrayList<>();
//    LinkedList<Integer> path = new LinkedList<>();
//    public List<List<Integer>> combinationSum3(int k, int n) {
//        backtracking(k,n,1,0);
//        return result;
//    }

//    private void backtracking(int k,int targetSum,int startIndex,int sum){
//        if (sum>targetSum)
//            return;
//        if (path.size() == k){
//            if (sum==targetSum)
//                result.add(new ArrayList<>(path));
//            return;
//        }
//
//        for (int i=startIndex;i<=9-(k-path.size())+1;i++){
//            path.add(i);
//            sum+=i;
//            backtracking(k,targetSum,i+1,sum);
//            //回溯
//            path.removeLast();
//            //回溯-----removeLast后还需还原sum值
//            sum-=i;
//        }
//    }
}
