/*
 * @lc app=leetcode id=32 lang=java
 *
 * [32] Longest Valid Parentheses
 */

// @lc code=start
class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == ')') {
                if(s.charAt(i - 1) == ')') {
                    // eg: "()(()))", when i = 6, s[i] = ')'. so dp[i-1] == i (means 0~i-1 is valid)
                    // eg: "()(())", when i = 5, s[i] = ')'. j = i - dp[i-1] - 1 means symmetry one which is j = 3 and s[j] = '('
                    if(dp[i-1] != i && dp[i-1] != 0 && s.charAt(i - dp[i-1] - 1) == '(') {
                        // eg: "(()())", when i = 5, j = i - dp[i-1] - 1 is 0
                        dp[i] = (i - dp[i-1] - 1 == 0 ? 0 : dp[i - dp[i-1] - 2]) + dp[i-1] + 2;
                    } else {
                        dp[i] = 0;
                    }
                } else {
                    dp[i] = i < 2 ? 2 : dp[i-2] + 2;
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
// @lc code=end

