import java.util.Arrays;

/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start
class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length())
            return false;

        int[] arr1 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            arr1[s1.charAt(i) - 'a'] += 1;
        }

        char[] arr2 = s2.toCharArray();
        int left = 0, n = s1.length(), right = n - 1;
        while (right < s2.length()) {
            int[] tempArr = Arrays.copyOf(arr1, 26);
            int k = n;
            int prev = left;
            while (left <= right) {
                if (tempArr[arr2[left] - 'a'] == 0)
                    break;
                tempArr[arr2[left] - 'a'] -= 1;
                left++;
                k--;
            }
            if (k == 0)
                return true;
            left = prev + 1;
            right++;
        }

        return false;

    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.checkInclusion("adc", "dcda"));
    }
}
// @lc code=end
