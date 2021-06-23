/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        char[] cs = s.toCharArray();
        if(cs.length <= 0) return 0;

        int begin = 0;
        // remove whitespace
        while (begin < cs.length && cs[begin] == ' ') {
            begin++;
        }
        // check if is positive
        int sign = 1;
        if(begin < cs.length && (cs[begin] == '-' || cs[begin] == '+')) {
            // '+' - '-' == -2 is true
            sign = sign + ('+' - cs[begin]);
            begin++;
        }

        int t = 0;
        while (begin < cs.length && cs[begin] >= '0' && cs[begin] <= '9') {
            int m = cs[begin++] - '0';
            // will exec t * 10; if t > Integer.MAX_VALUE / 10 then t will be over ranged
            // will exec t + m; if t == Integer.MAX_VALUE / 10, 
            // we need to check whether m bigger than 7 (Integer.MAX_VALUE & 10)
            if (t > Integer.MAX_VALUE / 10 || (t == Integer.MAX_VALUE / 10) && m > Integer.MAX_VALUE % 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            t = t * 10 + m;
        }
        return t * sign;
    }
}
// @lc code=end

