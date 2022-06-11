#
# @lc app=leetcode id=2210 lang=python3
#
# [2210] Count Hills and Valleys in an Array
#

# @lc code=start
from typing import List


class Solution:
    # def countHillValley(self, nums: List[int]) -> int:
    #     result = 0

    #     left = 0
    #     right = 0
    #     for i, val in enumerate(nums[1:], 1):
    #         if(i == len(nums) - 1):
    #             break
    #         left = i
    #         right = i + 1
    #         while left > 0:
    #             if(val != nums[left]):
    #                 break
    #             left -= 1
    #         while right < len(nums) - 1:
    #             if(val != nums[right]):
    #                 break
    #             right += 1

    #         if((val != nums[i - 1]) and ((nums[left] < val and nums[right] < val) or (nums[left] > val and nums[right] > val))):
    #             result += 1

    #     return result

    
    def countHillValley(self, nums: List[int]) -> int:
        '''O(n)'''
        nums1 = [nums[0]]
        for i in range(1, len(nums)):
            if nums[i] != nums1[-1]:
                nums1.append(nums[i])
        cnt = 0
        for i in range(1, len(nums1) - 1):
            if nums1[i - 1] < nums1[i] > nums1[i + 1] or nums1[i - 1] > nums1[i] < nums1[i + 1]:
                cnt += 1
        return cnt        


sol = Solution()
print(sol.countHillValley([6, 6, 5, 5, 4, 1]))

# @lc code=end
