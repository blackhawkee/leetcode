import java.util.Arrays;

/*
 * @lc app=leetcode id=2294 lang=java
 *
 * [2294] Partition Array Such That Maximum Difference Is K
 */

// @lc code=start
class Solution {
    public int partitionArray(int[] nums, int k) {

        int result = 1;
        Arrays.sort(nums);
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[j] > k) {
                result++;
                j = i;
            }
        }

        return result;
    }
}
// @lc code=end
