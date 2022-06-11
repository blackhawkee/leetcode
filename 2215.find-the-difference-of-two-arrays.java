import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode id=2215 lang=java
 *
 * [2215] Find the Difference of Two Arrays
 */

// @lc code=start
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int val : nums1) {
            map1.put(val, map1.getOrDefault(val, 0) + 1);
        }

        for (int val : nums2) {
            map2.put(val, map2.getOrDefault(val, 0) + 1);
        }

        List<Integer> list1 = new ArrayList<>();
        for (int val : nums1) {
            if (!map2.containsKey(val) && !list1.contains(val))
                list1.add(val);
        }

        List<Integer> list2 = new ArrayList<>();
        for (int val : nums2) {
            if (!map1.containsKey(val) && !list2.contains(val))
                list2.add(val);
        }

        return List.of(list1, list2);
    }
}
// @lc code=end
