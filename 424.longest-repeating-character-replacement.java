import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=424 lang=java
 *
 * [424] Longest Repeating Character Replacement
 */

// @lc code=start
class Solution {
    public int characterReplacement(String s, int k) {
        char[] arr = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        int left = 0, maxCnt = 0;
        int result = 0;
        for (int right = 0; right < s.length(); right++) {
            if (map.get(arr[right]) != null) {
                map.put(arr[right], map.get(arr[right]) + 1);
            } else {
                map.put(arr[right], 1);
            }
            maxCnt = Math.max(maxCnt, map.get(arr[right]));

            while (right - left + 1 - maxCnt > k) {
                map.put(arr[left], map.get(arr[left]) - 1);
                left++;
            }

            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
// @lc code=end
