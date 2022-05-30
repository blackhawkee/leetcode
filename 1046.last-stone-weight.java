import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=1046 lang=java
 *
 * [1046] Last Stone Weight
 */

// @lc code=start
class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pQueue = new PriorityQueue<>((a, b) -> b - a);

        for (int val : stones) {
            pQueue.offer(val);
        }

        System.out.println(pQueue);

        while (pQueue.size() > 1) {
            pQueue.offer(pQueue.poll() - pQueue.poll());
        }

        return pQueue.poll();

    }

}
// @lc code=end
