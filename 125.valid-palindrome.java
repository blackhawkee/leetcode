/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {

        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            int intVal = (int) arr[i];
            if (intVal >= 65 && intVal <= 90)
                arr[i] = (char) (97 + intVal - 65);
            else if (intVal >= 48 && intVal <= 57)
                arr[i] = arr[i];
            else if (!(intVal >= 97 && intVal <= 122))
                arr[i] = ' ';
        }

        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] == ' ')
                left++;
            else if (arr[right] == ' ')
                right--;
            else {
                if (arr[left] != arr[right])
                    return false;
                left++;
                right--;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.isPalindrome("0P"));
    }
}
// @lc code=end
