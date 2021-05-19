/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    
    public String longestPalindrome(String s) {
        return longestPalindromeON2(s);
    }

    public String longestPalindromeON2(String s) {
        if(s.length() <= 2) {
            return s.length() < 2 ? s : s.charAt(0) == s.charAt(1) ? s : s.substring(0, 1);
        }

        char[] chs = new char[s.length() * 2 + 1];
        for (int n = 0, m = 0; m < chs.length; m++) {
            if(m % 2 == 0) {
                chs[m] = '#';
            } else {
                chs[m] = s.charAt(n);
                n++;
            }
        }
        int center = 0, length = 0;
        int i = 1, j = 2;
        while (j < chs.length) {
            if(i == j) {
                j++;
            }
            int lg = i * 2 - j;
            if(lg >= 0 && chs[lg] == chs[j]) {
                if((j - i) > length) {
                    center = i;
                    length = j - i;
                }
                j++;
            } else {
                i++;
                j = i + 1;
            }
        }
        return new String(chs).substring(center - length, center + length + 1).replaceAll("#","");
    }
}
// @lc code=end

class Test {
    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("abcdefggfedcba"));
    }
}
