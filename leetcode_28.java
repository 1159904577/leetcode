public class leetcode_28 {
    public static void main(String[] args) {

    }

    public int strStr(String haystack, String needle) {
        int start = 0;
        int end = 0;

        for (start = 0; start < haystack.length(); start++) {
            end = start;
            int needleIndex=0;
            while (end<haystack.length() && needleIndex<needle.length() && haystack.charAt(end)==needle.charAt(needleIndex)){
                end++;
                needleIndex++;
            }
            if (end-start==needle.length()){
                return start;
            }
        }
        return -1;
    }
}
