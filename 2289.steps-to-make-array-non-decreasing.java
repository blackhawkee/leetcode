import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=2289 lang=java
 *
 * [2289] Steps to Make Array Non-decreasing
 */

// @lc code=start
class Solution {
    public int totalSteps(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        Arrays.fill(arr, 0);
        int[] stack = new int[n];
        int top = -1, result = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (top >= 0 && nums[i] > nums[stack[top]]) {
                arr[i] = Math.max(++arr[i], arr[stack[top--]]);
                result = Math.max(result, arr[i]);
            }
            stack[++top] = i;
        }

        return result;
    }
}
// @lc code=end
