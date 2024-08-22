public class leetcode_11 {
    public int maxArea(int[] height) {
        int max=0;
        int left =0;
        int right = height.length-1;
        while (left<right){
            int area=(right-left)*Math.min(height[left],height[right]);
            max=Math.max(max,area);

            //当height[left]<=height[right]时，说明可能是左边的值过小导致max小
            if (height[left]<=height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max;
    }
}
