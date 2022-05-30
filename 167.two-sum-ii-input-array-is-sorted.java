/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input Array Is Sorted
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        int left = 0, right = numbers.length - 1;

        while (left < right) {
            int tempSum = numbers[left] + numbers[right];
            if (tempSum == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }
            if (tempSum > target) {
                right--;
            } else if (tempSum < target) {
                left++;
            }
        }

        return result;
    }
}
// @lc code=end
