/*
 * @lc app=leetcode id=9 lang=java
 *
 * [9] Palindrome Number
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0 || (x >= 10 && x % 10 == 0)) return false;
        int low = 0;
        while (x > low) {
            low = low * 10 + x % 10;
            x = x / 10;
        }
        return x == low || x == low / 10;
    }
}
// @lc code=end

