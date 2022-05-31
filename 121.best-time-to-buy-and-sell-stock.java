/*
 * @lc app=leetcode id=121 lang=java
 *
 * [121] Best Time to Buy and Sell Stock
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;
        if (n <= 1) {
            return 0;
        }

        int buy = 0, sell = 1, profit = -1;
        while (sell < n) {
            if (prices[sell] - prices[buy] > 0) {
                profit = Math.max(profit, prices[sell] - prices[buy]);
            } else {
                while (buy < sell) {
                    buy++;
                    profit = Math.max(profit, prices[sell] - prices[buy]);
                }
            }
            sell++;

        }

        return profit;
    }
}
// @lc code=end
