/*
 * @lc app=leetcode id=2293 lang=java
 *
 * [2293] Min Max Game
 */

// @lc code=start
class Solution {
    public int minMaxGame(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int n = nums.length;
        int newNums[] = new int[n / 2];
        for (int i = 0; i < newNums.length; i++) {
            if (i % 2 == 0) {
                newNums[i] = Math.min(nums[2 * i], nums[2 * i + 1]);
            } else {
                newNums[i] = Math.max(nums[2 * i], nums[2 * i + 1]);
            }

        }

        return minMaxGame(newNums);
    }
}
// @lc code=end
