/*
 * @lc app=leetcode id=2220 lang=java
 *
 * [2220] Minimum Bit Flips to Convert Number
 */

// @lc code=start
class Solution {
    public int minBitFlips(int start, int goal) {
        String s1 = Integer.toBinaryString(start);
        String s2 = Integer.toBinaryString(goal);

        int result = 0, i = 0, j = 0;
        for (i = s1.length() - 1, j = s2.length() - 1; i >= 0 && j >= 0; i--, j--) {
            if (s1.charAt(i) != s2.charAt(j))
                result++;
        }
        if (i < 0) {
            while (j >= 0) {
                if (s2.charAt(j) == '1')
                    result++;
                j--;
            }
        }
        if (j < 0) {
            while (i >= 0) {
                if (s1.charAt(i) == '1')
                    result++;
                i--;
            }
        }

        return result;
    }
}
// @lc code=end
