public class leetcode_242 {
    public static void main(String[] args) {

    }

    public boolean isAnagram(String s, String t) {

        if (s.length()!=t.length()){
            return false;
        }

        int[] arr = new int[26];
        for (char c : s.toCharArray()){
            arr[c-'a']++;
        }

        for (char c : t.toCharArray()){
            arr[c-'a']--;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=0){
                return false;
            }
        }

        return true;
    }

}
