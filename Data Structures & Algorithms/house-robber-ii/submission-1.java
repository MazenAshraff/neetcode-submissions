class Solution {
    public int rob(int[] nums) {
        if(nums.length < 3) return Math.max(nums[0],nums[nums.length-1]);
        int len = nums.length;
        int dp[][] = new int [2][nums.length];
        dp[0][0]= nums[0];
        dp[0][1] = Math.max(nums[0],nums[1]);
        dp[1][len - 1] = nums[len - 1];
        dp[1][len -2] = Math.max(nums[len - 1], nums[len - 2]);
        for(int i = 2;i< len - 1; i++){
            dp[0][i] = Math.max(dp[0][i-1],dp[0][i-2]+nums[i]);
        }
        for(int i = len - 3; i>0;i--){
            dp[1][i] = Math.max(dp[1][i+1], nums[i]+ dp[1][i+2]);
        }
        return Math.max(dp[1][1],dp[0][len-2]);

        
    }
}
