/*
 * @lc app=leetcode id=123 lang=java
 *
 * [123] Best Time to Buy and Sell Stock III
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 1) {
            return 0;
        }

        // c1: 1st buy cost
        // p1: balance after 1st sold
        // c2: balance after 2nd buy
        // p2: balance after 2nd sold
        // eg: a1, a2, a3, a4
        // return (a2 - a1) + (a4 - a3) => a2 - a1 - a3 + a4
        // c1 = a1, p1 = a2 - a1, c2 = a2 - a1 - a3, p2 = a2 - a1 - a3 + a4
        int c1 = Integer.MAX_VALUE, p1 = 0, c2 = Integer.MIN_VALUE, p2 = 0;
        for (int price : prices) {
            c1 = Math.min(price, c1);
            p1 = Math.max(p1, price - c1);
            c2 = Math.max(c2, p1 - price);
            p2 = Math.max(p2, price + c2);
        }
        return p2;
    }
}
// @lc code=end

