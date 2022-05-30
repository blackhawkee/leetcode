import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        // List<Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        var list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (e1, e2) -> e2.getValue() - e1.getValue());

        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }

        return result;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] result = obj.topKFrequent(new int[] { 2, 1, 1, 1, 2, 3 }, 2);
        System.out.println("in main");
        Arrays.stream(result).forEach(i -> System.out.println(i));
    }
}
// @lc code=end
