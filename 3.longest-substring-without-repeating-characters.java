import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {

        if (s.length() <= 1)
            return s.length();

        int result = 1;
        char[] arr = s.toCharArray();
        int left = 0, right = 1;
        Set<Character> set = new HashSet<>();
        set.add(arr[left]);
        while (right < s.length()) {

            boolean bTest = set.add(arr[right]);
            if (bTest) {
                result = Math.max(result, set.size());
            } else {
                while (!set.add(arr[right]) && left < right) {
                    set.remove(arr[left]);
                    left++;
                }
            }
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
    }
}
// @lc code=end
