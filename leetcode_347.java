import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class leetcode_347 {
    public static void main(String[] args) {

    }

    public static int[] topKFrequent(int[] nums,int k){
        //key:元素值   value:元素出现的次数
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
             map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        //使用小根堆PriorityQueue，小跟堆size为k
        //每次pop出去最小的，保留k个频率最大的元素
        //优先队列中存储二元组（num，cnt）
        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1,pair2)->pair1[1]-pair2[1]);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(pq.size()<k){
                pq.add(new int[]{entry.getKey(),entry.getValue()});
            }else{
                if (entry.getValue()>pq.peek()[1]){
                    pq.poll();
                    pq.add(new int[]{entry.getKey(),entry.getValue()});
                }
            }
        }

        int[] res = new int[k];
        for(int i=k-1;i>=0;i--){
            res[i]=pq.poll()[0];
        }
        return res;
    }
}
