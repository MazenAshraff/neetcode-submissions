class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length][nums.length+1];
        return maxLen(nums,dp,0, -1);
    }
    public int maxLen(int [] nums, int [][] dp,int i, int j){
        if(i == nums.length) return 0;
        if(j != -1 && dp[i][j] != 0) return dp[i][j];
        if(j == -1){
            return Math.max(1 + maxLen(nums, dp,i + 1, i), maxLen(nums, dp,i + 1, j));
        }
        if(nums[i]> nums[j]){
            return dp[i][j] =  Math.max(1 + maxLen(nums, dp,i + 1, i), maxLen(nums, dp,i + 1, j));
        }
        else{
            return dp[i][j] =  maxLen(nums,dp,i+1, j);
        }
    }
}
