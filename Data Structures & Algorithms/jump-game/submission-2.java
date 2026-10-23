class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (maxReach >= i) {
                maxReach = Math.max(maxReach, i + nums[i]);
            } else {
                return false;
            }
        }
        return true;
    }
}
