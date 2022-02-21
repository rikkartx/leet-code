/*
 * @lc app=leetcode id=416 lang=java
 *
 * [416] Partition Equal Subset Sum
 */

// @lc code=start
class Solution {
    public boolean canPartition(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return false;
        }

        // calculate sum
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        // return false if sum is odd
        if(sum % 2 == 1) {
            return false;
        }
        // just find if there are number's sum == target
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] | dp[j - nums[i]];
            }
        }
        return dp[target];
    }
}
// @lc code=end

