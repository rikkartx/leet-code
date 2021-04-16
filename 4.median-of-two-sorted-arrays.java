/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    
    /**
     * 
     * @param nums1 short array
     * @param nums2 array2
     * @return median of two sorted arrays
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // To find a we need to search in short array
        // so make sure nums1 is short one
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0; 
        int high = nums1.length;
        int t = nums1.length + nums2.length;
        while(low <= high) {
            int sm = (low + high) / 2;
            int lm = t / 2 - sm;

    
            double ls = sm == 0 ? Integer.MIN_VALUE : nums1[sm - 1];
            double ll = lm == 0 ? Integer.MIN_VALUE : nums2[lm - 1];
            double rs = sm == nums1.length ? Integer.MAX_VALUE : nums1[sm];
            double rl = lm == nums2.length ? Integer.MAX_VALUE : nums2[lm];

            // ls <= rs && ll <= rl is ture
            // so ensure ls <= rl && ll <= rs
            if(ls > rl) {
                // sm is too big, move it to left
                low--;
            } else if(ll > rs) {
                // sn is too small move it to right
                low++;
            } else {
                return t%2 == 0 ? (Math.max(ls, ll) + Math.min(rs, rl)) / 2 : Math.min(rs, rl);
            }
        }
        return -1d;
    }
}
// @lc code=end

class Test {
    public static void main(String[] args) {
        System.out.println(new Solution().findMedianSortedArrays(
            new int[]{1,3,5,7,9}, new int[]{2,4,6,8,10}));
    }
}
