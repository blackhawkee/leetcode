import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=128 lang=java
 *
 * [128] Longest Consecutive Sequence
 */

// @lc code=start
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;

        Set<Integer> set = new HashSet<>();
        for (Integer intVal : nums) {
            set.add(intVal);
        }

        int result = Integer.MIN_VALUE;
        for (Integer intVal : nums) {
            int sum = 0;

            if (!set.contains(intVal - 1)) {
                sum++;
                int nextVal = intVal + 1;
                while (set.contains(nextVal)) {
                    sum++;
                    nextVal++;
                }
                result = Math.max(result, sum);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.longestConsecutive(new int[] { 1 }));
    }
}
// @lc code=end
