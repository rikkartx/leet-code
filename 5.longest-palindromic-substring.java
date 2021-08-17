/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
    
    public String longestPalindrome(String s) {
        return longestPalindromeON(s);
    }

    public String longestPalindromeON(String strings) {
        if(strings == null || strings.length() <= 1) {
            return strings;
        }
        int len = strings.length();
        char[] s = new char[len * 2 + 1];
        int[] p = new int[s.length];
        for (int i = 0,j = 0; i < len;) {
            if(j % 2 == 0) {
                s[j++] = '#';
            } else {
                s[j++] = strings.charAt(i++);
                if(i == len) {
                    s[j] = '#';
                }
            }
        }
        int r = 0, c = 0;
        for (int i = 1; i < s.length; i++) {
            p[i] = r > i ? Math.min(r - i, p[c * 2 - i]) : 0;
            while (i + p[i] + 1 < s.length && i - p[i] - 1 > -1 && s[i + p[i] + 1] == s[i - p[i] - 1]) {
                p[i]++;
            }
            if(i + p[i] > r) {
                c = i;
                r = i + p[i];
            }
        }
        int max = p[0], maxi = 0;
        for (int i = 1; i < p.length; i++) {
            if(p[i] > max) {
                max = p[i];
                maxi = i;
            }
        }
        return strings.substring((maxi - max) / 2, (maxi + max) / 2);
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
