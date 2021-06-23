/*
 * @lc app=leetcode id=70 lang=java
 *
 * [70] Climbing Stairs
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        // f(n) = f(n - 1) + f(n - 2)
        // n >= 3
        // p = f(n - 1), pp = f(n - 2)
        int p = 2, pp = 1, c = 3;
        for (int i = 3; i <= n; i++) {
            c = p + pp;
            pp = p;
            p = c;
        }
        return c;
    }
}
// @lc code=end

