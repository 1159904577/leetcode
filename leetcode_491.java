import java.util.*;

public class leetcode_491 {
    public static void main(String[] args) {

    }
    List<List<Integer>> ll = new ArrayList<>();
    LinkedList<Integer> l = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums){
        if (nums.length<2){
            return ll;
        }
        backTracking(nums,0);
        return ll;
    }

    private void backTracking(int[] nums,int startIndex){
        if (l.size()>=2){
            ll.add(new ArrayList<>(l));
        }
        HashSet<Integer> hs = new HashSet<>();
        for (int i=startIndex;i<nums.length;i++){
            if(!l.isEmpty() && l.peekLast() > nums[i] || hs.contains(nums[i]))
                continue;
            hs.add(nums[i]);
            l.add(nums[i]);
            backTracking(nums,i+1);
            l.removeLast();
        }
    }
}
