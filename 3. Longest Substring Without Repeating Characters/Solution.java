import java.util.HashSet;

class Solution {
    /*
        The idea is to use a sliding window. We stop the loop when the 2nd pointer reaches the end of the string. Otherwise, we check if the char at the second point exists 
        in our hashset, if it does not then add the char to the hashset and increase the second pointer. We then check if the current window is bigger than our current max.
        If it does, we will make the window smaller until there are no repeats in the current window.

        The reason we use hashset is because on average, checking existence runs in O(1) time. 
    */
    public int lengthOfLongestSubstring(String s) {
        int pointer1 = 0;
        int pointer2 = 0;
        int max = 0;
        HashSet<Character> dict = new HashSet<Character>();

        while(pointer2 < s.length()) {
            if (!dict.contains(s.charAt(pointer2))) {
                dict.add(s.charAt(pointer2));
                pointer2++;
                max = Math.max(max, pointer2 - pointer1);
            } else {
                dict.remove(s.charAt(pointer1));
                pointer1++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        Solution solution = new Solution();
        System.out.println("The Solution is: " + solution.lengthOfLongestSubstring(s));
    }
}