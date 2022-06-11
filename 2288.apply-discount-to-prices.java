import java.text.DecimalFormat;

/*
 * @lc app=leetcode id=2288 lang=java
 *
 * [2288] Apply Discount to Prices
 */

// @lc code=start
class Solution {
    public String discountPrices(String sentence, int discount) {
        DecimalFormat df = new DecimalFormat("0.00");

        String[] arr = sentence.split(" ");
        StringBuffer sBuffer = new StringBuffer();
        for (String str : arr) {
            if (str.charAt(0) == '$' && isNumeric(str.substring(1))) {
                double d = Double.parseDouble(str.substring(1)) * (1 - discount * 0.01);

                sBuffer.append("$").append(df.format(d)).append(" ");
            } else {
                sBuffer.append(str).append(" ");
            }
        }

        return new String(sBuffer.substring(0, sBuffer.length() - 1));
    }

    public static boolean isNumeric(String str) {
        if (str == null || str.length() == 0)
            return false;
        for (char ch : str.toCharArray()) {
            if (!Character.isDigit(ch))
                return false;
        }
        return true;
    }
}
// @lc code=end
