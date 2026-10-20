class Solution {
    public int rob(int[] nums) {
        int [] mon = new int[nums.length];
        mon[0] = nums[0];
        if(nums.length > 1){
            mon[1] = Math.max(nums[0], nums[1]);
        }
        for(int i = 2; i < nums.length; i++){
            mon[i] = Math.max(mon[i - 1], mon[i-2] + nums[i]);
        }

        return mon[nums.length - 1];
    }
}
