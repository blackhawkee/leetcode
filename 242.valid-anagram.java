import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        char[] tArr = t.toCharArray();
        for (char c : tArr) {
            if (map.containsKey(c)) {
                if (map.get(c) - 1 == 0)
                    map.remove(c);
                else
                    map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
