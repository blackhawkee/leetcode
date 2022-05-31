import java.util.Arrays;

/*
 * @lc app=leetcode id=42 lang=java
 *
 * [42] Trapping Rain Water
 */

// @lc code=start
class Solution {
    public int trap(int[] height) {

        int[] prefix = new int[height.length];
        Arrays.fill(prefix, 0);
        int[] suffix = new int[height.length];
        Arrays.fill(suffix, 0);

        int[] result = new int[height.length];

        for (int i = 1; i < height.length; i++) {
            prefix[i] = Math.max(height[i - 1], prefix[i - 1]);

        }

        for (int i = height.length - 2; i >= 0; i--) {
            suffix[i] = Math.max(height[i + 1], suffix[i + 1]);
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = Math.min(prefix[i], suffix[i]) - height[i];
        }

        int output = 0;
        for (int val : result) {
            if (val < 0)
                continue;
            output += val;
        }

        return output;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
        System.out.println(obj.trap(new int[] { 4, 2, 0, 3, 2, 5 }));
    }
}
// @lc code=end
