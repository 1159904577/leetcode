import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode_78 {
    public static void main(String[] args) {

    }

    List<List<Integer>> ll = new ArrayList<>();
    LinkedList<Integer> l = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums){
        backTracking(nums,0);
        return ll;
    }

    private void backTracking(int[] nums,int startIndex){
        ll.add(new ArrayList<>(l));
        if (l.size() == nums.length) {
            return;
        }

        for (int i=startIndex;i<nums.length;i++){
            l.add(nums[i]);
            backTracking(nums,i+1);
            l.removeLast();
        }

    }
}
