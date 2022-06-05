import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=2295 lang=java
 *
 * [2295] Replace Elements in an Array
 */

// @lc code=start
class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int[] is : operations) {
            map.put(is[1], map.get(is[0]));
            nums[map.get(is[0])] = is[1];
            map.remove(is[0]);
        }

        return nums;
    }
}
// @lc code=end
