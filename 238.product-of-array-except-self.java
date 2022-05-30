import java.util.Arrays;

/*
 * @lc app=leetcode id=238 lang=java
 *
 * [238] Product of Array Except Self
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] prefixArr = new int[nums.length];
        Arrays.fill(prefixArr, 1);
        int[] suffixArr = new int[nums.length];
        Arrays.fill(suffixArr, 1);

        for (int i = 1; i < nums.length; i++) {
            prefixArr[i] = prefixArr[i - 1] * nums[i - 1];
        }

        for (int j = nums.length - 2; j >= 0; j--) {
            suffixArr[j] = nums[j + 1] * suffixArr[j + 1];
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = prefixArr[i] * suffixArr[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int result[] = obj.productExceptSelf(new int[] { 1, 2, 3, 4 });
        for (int i : result) {
            System.out.println(i);
        }
    }
}
// @lc code=end
