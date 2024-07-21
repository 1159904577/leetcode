import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode_77 {
    public static void main(String[] args) {

    }

    //给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,1);
        return result;
    }
    public void backtracking(int n,int k,int startIndex){
        if (path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }

        //i为本次搜索的起始位置
        for (int i=startIndex;i<=n-(k - path.size())+1;i++){
            path.add(i);
            backtracking(n,k,i+1);
            path.removeLast();
        }
    }
}
