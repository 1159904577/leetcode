import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leetcode_46 {
    public static void main(String[] args) {

    }
    List<List<Integer>> ll = new ArrayList<>();
    LinkedList<Integer> l = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums){
        backTracking(nums,l);
        return ll;
    }

    private void backTracking(int[] nums,LinkedList l){
        if (l.size() == nums.length) {
            ll.add(new ArrayList<>(l));
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (l.contains(nums[i])){
                continue;
            }
            l.add(nums[i]);
            backTracking(nums,l);
            l.removeLast();
        }
    }
}
