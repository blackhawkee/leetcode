#
# @lc app=leetcode id=2239 lang=python3
#
# [2239] Find Closest Number to Zero
#

# @lc code=start

class Solution:
    def findClosestNumber(self, nums: List[int]) -> int:
        result = nums[0]
        for i in nums:
            if abs(i) < abs(result):
                result = i
            elif abs(i) == abs(result) and result < 0:
                result = i

        return result
# @lc code=end
