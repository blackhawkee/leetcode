import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> oLists = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int target = 0 - nums[i];
                int left = i + 1;
                int right = nums.length - 1;

                while (left < right) {
                    if (nums[left] + nums[right] == target) {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        oLists.add(list);
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (nums[left] + nums[right] > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }


        // for (int i = 0; i < nums.length; i++) {
        //     int left = 1, right = nums.length - 1;
        //     int target = nums[i];

        //     if (i != 0)
        //         left = 0;
        //     if (i == nums.length - 1)
        //         right = nums.length - 2;

        //     while (left < right) {
        //         if (i == left || visited[left]) {
        //             left++;
        //             continue;
        //         }

        //         if (i == right || visited[right]) {
        //             right--;
        //             continue;
        //         }

        //         int tempSum = nums[left] + nums[right];
        //         if (tempSum + target == 0) {
        //             List<Integer> list = new ArrayList<>();
        //             list.add(target);
        //             list.add(nums[left]);
        //             list.add(nums[right]);
        //             oLists.add(list);
        //             visited[i] = true;
        //             visited[left] = true;
        //             visited[right] = true;
        //             left++;
        //             right--;
        //             continue;
        //         }

        //         if (tempSum > target) {
        //             right--;
        //         } else if (tempSum < target) {
        //             left++;
        //         } else {
        //             left++;
        //             right--;
        //         }
        //     }
        // }

        /*
        for (int i = 0; i < oLists.size(); i++) {
            List<Integer> l1 = oLists.get(i);
            for (int j = i; j < oLists.size(); j++) {
                List<Integer> l2 = oLists.get(j);
                if ((l1.containsAll(l2) && l1.size() == l2.size()))
                    oLists.remove(l2);
            }
        }
        */

        return oLists;
    }

}
// @lc code=end
