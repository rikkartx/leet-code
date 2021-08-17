/*
 * @lc app=leetcode id=516 lang=java
 *
 * [516] Longest Palindromic Subsequence
 */

// @lc code=start
class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        } else if(s.length() == 1) {
            return 1;
        }

        int max = 0;
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i-1][j+1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j+1]);
                }
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
// @lc code=end

