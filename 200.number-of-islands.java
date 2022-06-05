import java.util.ArrayDeque;
import java.util.Queue;

/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
    boolean visited[][];
    int m;
    int n;

    public int numIslands(char[][] grid) {

        m = grid.length;
        n = grid[0].length;
        if (m == 1 && n == 1) {
            return grid[0][0] == '1' ? 1 : 0;
        }

        visited = new boolean[m][n];
        int result = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == '1' && !visited[row][col]) {
                    result++;
                    bfs(grid, row, col);
                }
            }
        }

        return result;

    }

    class Node {
        int row;
        int col;

        Node(int i, int j) {
            this.row = i;
            this.col = j;
        }
    }

    void bfs(char[][] grid, int row, int col) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(new Node(row, col));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (visited[node.row][node.col]) {
                continue;
            }
            visited[node.row][node.col] = true;

            if (node.row + 1 < m && grid[node.row + 1][node.col] == '1')
                queue.add(new Node(node.row + 1, node.col));
            if (node.row - 1 >= 0 && grid[node.row - 1][node.col] == '1')
                queue.add(new Node(node.row - 1, node.col));
            if (node.col + 1 < n && grid[node.row][node.col + 1] == '1')
                queue.add(new Node(node.row, node.col + 1));
            if (node.col - 1 >= 0 && grid[node.row][node.col - 1] == '1')
                queue.add(new Node(node.row, node.col - 1));
        }
    }
}
// @lc code=end
