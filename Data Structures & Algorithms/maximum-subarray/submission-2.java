class Solution {
    public int maxSubArray(int[] nums) {
        int curMax = nums[0];
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > cur && cur < 0) {
                cur = nums[i];
            } else {
                if (cur + nums[i] >= 0 || cur + nums[i] >= nums[i]) {
                    cur += nums[i];
                }
            }
            curMax = Math.max(curMax, cur);
        }
        return curMax;
    }
}
