/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        } else if(s.length() == 1) {
            return 1;
        }
        
        char[] chs = s.toCharArray();
        int max = 1;
        int nestLoopBegin = 0;
        for (int i = 1; i < chs.length; i++) {
            for (int j = nestLoopBegin; j < i; j++) {
                if(chs[i] == chs[j]) {
                    nestLoopBegin = ++j;
                    break;
                }
            }
            max = Math.max(max, i - nestLoopBegin + 1);
        }
        return max;
    }
}
// @lc code=end

