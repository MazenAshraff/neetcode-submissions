class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        Integer prev = null;
        int curMin = nums[0];
        int curMax = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curMinTemp = curMin;
            curMin = Math.min(Math.min(curMin*nums[i], curMax*nums[i]), nums[i]);
            curMax = Math.max(Math.max(curMinTemp*nums[i], curMax*nums[i]), nums[i]);
            max = Math.max(max, curMax);
        }
        return max;
    }
}
