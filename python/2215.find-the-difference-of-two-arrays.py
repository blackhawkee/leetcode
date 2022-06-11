#
# @lc app=leetcode id=2215 lang=python3
#
# [2215] Find the Difference of Two Arrays
#

# @lc code=start
from typing import List


class Solution:
    def findDifference(self, nums1: List[int], nums2: List[int]) -> List[List[int]]:
        s1 = set(nums1)
        s2 = set(nums2)

        l1 = []
        l2 = []
        for val in nums1:
            if val not in s2 and val not in l1:
                l1.append(val)

        for val in nums2:
            if val not in s1 and val not in l2:
                l2.append(val)

        return [l1, l2]


obj = Solution()
print(obj.findDifference([1, 2, 3], [2, 4, 6]))
print(obj.findDifference([1, 2, 3, 3], [1, 1, 2, 2]))

# @lc code=end
