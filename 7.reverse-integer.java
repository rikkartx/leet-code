/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int rs = 0;
        for(int mod = x, divide = mod % 10; mod != 0; mod = mod / 10, divide = mod % 10) {
            int temp = rs * 10 + divide;
            if((temp - divide) / 10 != rs) {
                return 0;
            }
            rs = temp;
        }
        return rs;
    }
}
// @lc code=end

