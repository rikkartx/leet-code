/*
 * @lc app=leetcode id=13 lang=java
 *
 * [13] Roman to Integer
 */

// @lc code=start
class Solution {
    public int romanToInt(String s) {
        if(s == null || s.length() == 0) return 0;
        char[] cs = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < cs.length;i++) {
            int p = transToInt(cs[i]);
            int n = i == cs.length - 1  ? 0 : transToInt(cs[i + 1]);
            if(p < n) {
                sum -= p;
            } else {
                sum += p;
            }
        }
        return sum;
    }

    private int transToInt(char roman) {
        switch (roman) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
// @lc code=end

