/*
 * @lc app=leetcode id=2210 lang=java
 *
 * [2210] Count Hills and Valleys in an Array
 */

// @lc code=start
class Solution {
    public int countHillValley(int[] nums) {
        int result = 0;
        int left = 0, right = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            left = i - 1;
            right = i + 1;
            while (left > 0) {
                if (nums[left] != nums[i])
                    break;
                left--;
            }
            while (right < nums.length - 1) {
                if (nums[right] != nums[i])
                    break;
                right++;
            }

            if (((nums[left] < nums[i] && nums[right] < nums[i]) || (nums[left] > nums[i] && nums[right] > nums[i]))
                    && nums[i - 1] != nums[i]) {
                result++;
            }

        }
        return result;
    }

}
// @lc code=end
