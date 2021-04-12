import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> minus = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            Integer j;
            if((j = minus.get(current)) != null) {
                return new int[]{j, i};
            } else {
                minus.put(target - current, i);
            }
        }
        return new int[0];
    }
}
// @lc code=end

class Test {
    public static void main(String[] args) {
        int[] result = new Solution().twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
