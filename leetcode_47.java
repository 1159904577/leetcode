import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class leetcode_47 {
    public static void main(String[] args) {

    }

    static List<List<Integer>> ll = new ArrayList<>();
    static LinkedList<Integer> l = new LinkedList<>();
    public static List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        backTracking(nums,used);
        return ll;
    }

    private static void backTracking(int[] nums, boolean[] used){
        if (l.size() == nums.length) {
            ll.add(new ArrayList<>(l));
            return;
        }
        for (int i=0;i<nums.length;i++){
            // used[i - 1] == true，说明同⼀树⽀nums[i - 1]使⽤过
            // used[i - 1] == false，说明同⼀树层nums[i - 1]使⽤过
            // 如果同⼀树层nums[i - 1]使⽤过则直接跳过
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == true) {
                continue;
            }
            if (used[i] == false) {
                used[i] = true;//标记同⼀树⽀nums[i]使⽤过，防止同一树枝重复使用
                l.add(nums[i]);
                backTracking(nums, used);
                l.removeLast();//回溯，说明同⼀树层nums[i]使⽤过，防止下一树层重复
                used[i] = false;//回溯
            }
        }
    }

}
