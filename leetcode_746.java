public class leetcode_746 {
    public static void main(String[] args) {

    }

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length==3){
            return Math.min(cost[0]+cost[2],cost[1]);
        }
        int[] dp=new int[cost.length];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for (int i=2;i<dp.length;i++){
            dp[i]=cost[i]+Math.min(dp[i-1],dp[i-2]);
        }
        //最后应该比较倒数两个值
        //因为倒数第二个位置跨2步可以到达楼顶
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }
}
