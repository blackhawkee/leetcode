import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 */

// @lc code=start
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer integer : nums) {
            if (set.contains(integer))
                return true;
            else
                set.add(integer);
        }

        return false;
    }
}
