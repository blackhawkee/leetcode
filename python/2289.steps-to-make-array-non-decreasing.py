#
# @lc app=leetcode id=2289 lang=python3
#
# [2289] Steps to Make Array Non-decreasing
#

# @lc code=start
from typing import List


class Solution:
    def totalSteps(self, nums: List[int]) -> int:
        n = len(nums)
        arr = [0] * n
        stack = []
        for i in range(n-1, -1, -1):
            while stack and nums[i] > nums[stack[-1]]:
                arr[i] = max(arr[i] + 1, arr[stack.pop()])
            stack.append(i)
        return max(arr)


obj = Solution()
print(obj.totalSteps([5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11]))

# @lc code=end
