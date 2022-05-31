/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, result = 0;
        while (left < right) {
            result = Math.max(result, (right - left) * Math.min(height[left], height[right]));

            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return result;
    }

    /*
    // O(n^2) approach  // @formatter:off

    public int maxArea(int[] height) {
        int result = 0;
        for (int i = 0; i < height.length; i++) {
            int tempResult = 0;
            for (int j = i; j < height.length; j++) {
                tempResult = Math.max((j - i) * Math.min(height[j], height[i]), tempResult);
            }
            result = Math.max(result, tempResult);
        }

        return result;
    }
    // @formatter:on
    */

    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.maxArea(new int[] { 4, 3, 2, 1, 4 }));
        System.out.println(obj.maxArea(new int[] { 1, 1 }));
    }
}
// @lc code=end
