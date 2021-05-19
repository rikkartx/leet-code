/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] ZigZag Conversion
 */

// @lc code=start
class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1) {
            return s;
        }
        StringBuffer[] matrix = new StringBuffer[numRows];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new StringBuffer();
        }

        int n = 0, deep = 0;
        // true to bottom, false to top
        boolean toBottom = true;
        int chsLength = s.length();
        while (n < chsLength) {
            matrix[deep].append(s.charAt(n));
            if(toBottom) {
                deep++;
                if(deep == numRows - 1) {
                    toBottom = false;
                }
            } else {
                deep--;
                if(deep == 0) {
                    toBottom = true;
                }
            }
            n++;
        }

        StringBuffer rs = new StringBuffer();
        for (StringBuffer sb : matrix) {
            rs.append(sb);
        }
        return rs.toString();
    }
}
// @lc code=end

