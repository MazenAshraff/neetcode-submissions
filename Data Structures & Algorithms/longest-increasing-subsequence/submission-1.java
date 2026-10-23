class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length][nums.length+1];
        return maxLen(nums,dp,0, -1);
    }
    public int maxLen(int [] nums, int [][] dp,int i, int j){
        if(i == nums.length) return 0;
        if(dp[i][j+1] != 0) return dp[i][j+1];
        if(j == -1 || nums[i] > nums[j]){
            return dp[i][j+1] = Math.max(1 + maxLen(nums, dp,i + 1, i), maxLen(nums, dp,i + 1, j));
        }
        else{
            return dp[i][j+1] =  maxLen(nums,dp,i+1, j);
        }
    }
}
