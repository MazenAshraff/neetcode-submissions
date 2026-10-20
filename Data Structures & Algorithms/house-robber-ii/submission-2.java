class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[1], nums[0]);
        int n = nums.length;
        int [][]dp = new int[2][nums.length];
        dp[0][0] = nums[0];
        dp[0][1] = Math.max(nums[1], nums[0]);
        dp[1][n - 1] = nums[n-1];
        dp[1][n-2] = Math.max(nums[n-1], nums[n-2]);
        for(int i = 2, j = n - 3; i < n - 1 && j > 0; i++,j--){
            dp[0][i] = Math.max(dp[0][i-1], dp[0][i-2] + nums[i]);
            dp[1][j] = Math.max(dp[1][j+1], dp[1][j+2] + nums[j]);
        }

    return Math.max(dp[0][n-2], dp[1][1]); 
    }
}
