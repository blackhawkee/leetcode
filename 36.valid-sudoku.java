import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=36 lang=java
 *
 * [36] Valid Sudoku
 */
//36.valid-sudoku.java
// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        System.out.println(validateRows(board));
        System.out.println(validateColumns(board));
        System.out.println(validate3x3Boxes(board));
        return validateRows(board) && validateColumns(board) && validate3x3Boxes(board);
    }

    public boolean validateRows(char[][] board) {

        for (int row = 0; row < board.length; row++) {
            Set<Character> set = new HashSet<>();
            for (int column = 0; column < board.length; column++) {
                if (board[row][column] == '.')
                    continue;
                boolean bTest = set.add(board[row][column]);
                if (bTest == false)
                    return false;
            }
        }
        return true;
    }

    public boolean validateColumns(char[][] board) {

        for (int column = 0; column < board.length; column++) {
            Set<Character> set = new HashSet<>();
            for (int row = 0; row < board.length; row++) {
                if (board[row][column] == '.')
                    continue;
                boolean bTest = set.add(board[row][column]);
                if (bTest == false)
                    return false;
            }
        }
        return true;
    }

    public boolean validate3x3Boxes(char[][] board) {
        for (int initRow = 0; initRow < board.length; initRow += 3) {

            for (int initColumn = 0; initColumn < board.length; initColumn += 3) {

                Set<Character> set = new HashSet<>();
                for (int currRow = initRow; currRow < initRow + 3; currRow++) {
                    for (int currColumn = initColumn; currColumn < initColumn + 3; currColumn++) {
                        boolean bTest = true;
                        if (board[currRow][currColumn] != '.')
                            bTest = set.add(board[currRow][currColumn]);

                        if (bTest == false)
                            return false;
                    }

                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Create a new Solution instance
        Solution obj = new Solution();
        // Create a test case
        char[][] board = new char[][] {
                { '.', '.', '.', '.', '5', '.', '.', '1', '.' },
                { '.', '4', '.', '3', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '3', '.', '.', '1' },
                { '8', '.', '.', '.', '.', '.', '.', '2', '.' },
                { '.', '.', '2', '.', '7', '.', '.', '.', '.' },
                { '.', '1', '5', '.', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '2', '.', '.', '.' },
                { '.', '2', '.', '9', '.', '.', '.', '.', '.' },
                { '.', '.', '4', '.', '.', '.', '.', '.', '.' }
        };
        // Get the answer
        boolean answer = obj.isValidSudoku(board);
        // Print the answer
        System.out.println(answer);
    }

}

// @lc code=end
