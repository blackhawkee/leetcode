#
# @lc app=leetcode id=2303 lang=python3
#
# [2303] Calculate Amount Paid in Taxes
#

# @lc code=start
from typing import List


class Solution:
    def calculateTax(self, brackets: List[List[int]], income: int) -> float:
        prev = 0
        tax = 0.0
        for l1 in brackets:
            if income < l1[0] and income < prev:
                break
            tax += (min(income, l1[0]) - prev) * (0.01 * l1[1])
            prev = l1[0]
        return tax

# obj = Solution()
# print(obj.calculateTax([[3,50],[7,10],[12,25]], 10))
# print(obj.calculateTax([[1,0],[4,25],[5,50]], 2))
        
# @lc code=end

