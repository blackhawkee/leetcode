#
# @lc app=leetcode id=2288 lang=python3
#
# [2288] Apply Discount to Prices
#

# @lc code=start

class Solution:
    def discountPrices(self, sentence: str, discount: int) -> str:
        result = ''
        n = len(sentence)
        i = 0
        j = 0
        while i < n:
            result += sentence[i]
            if sentence[i] == '$' and (i == 0 or sentence[i-1] == ' '):
                j = i + 1
                while j < n and sentence[j].isdigit():
                    j += 1
                if(j - i > 1 and (j == n or sentence[j] == ' ')):
                    temp = (float(sentence[i + 1:j])) * ((1 - discount * 0.01))
                    result += f'{temp:.2f}'
                    i = j - 1
            
            i += 1
        return result


# obj = Solution()
# print(obj.discountPrices(sentence="ka3caz4837h6ada4 r1 $602", discount=9))
# print(obj.discountPrices("there are $1 $2 and 5$ candies in the shop", 50))
# print(obj.discountPrices("1 2 $3 4 $5 $6 7 8$ $9 $10$", 100))


# @lc code=end
