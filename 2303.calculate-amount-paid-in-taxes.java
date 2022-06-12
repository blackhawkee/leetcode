/*
 * @lc app=leetcode id=2303 lang=java
 *
 * [2303] Calculate Amount Paid in Taxes
 */

// @lc code=start
class Solution {
    public double calculateTax(int[][] brackets, int income) {
        DecimalFormat df = new DecimalFormat("#.#####");
        double tax = 0;
        for (int i = 0; i < brackets.length; i++) {
            double taxableIncome = 0;
            if (brackets[i][0] - income < 0) {
                if (i == 0) {
                    taxableIncome = brackets[i][0];
                } else {
                    taxableIncome = brackets[i][0] - brackets[i - 1][0];
                }

            } else {
                if (i == 0) {
                    if(income > 0) { 
                        if(income == brackets[i][0] || brackets[i][0] > income)
                            taxableIncome = income;
                        else
                            // taxableIncome = Math.abs(income - brackets[i][0]);
                            taxableIncome = brackets[i][0];
                    } else {
                        taxableIncome = income;
                    }
                } else {
                    taxableIncome = income - brackets[i - 1][0];
                }

            }
            if (taxableIncome < 0)
                continue;
            double percent = ((double) brackets[i][1] / 100);
            tax += taxableIncome * percent;

        }
        return tax;
    }
}
// @lc code=end
