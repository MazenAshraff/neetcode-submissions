class Solution {
    public int change(int amount, int[] coins) {
        int dp [][] = new int[coins.length][amount+1];
        for(int i = 0; i < dp.length;i++){
            Arrays.fill(dp[i], -1);
        }
        return solve(amount, coins,dp, 0);
    }

    public int solve(int amount, int []coins, int dp[][], int i){
        if(i == coins.length) return 0;
        if(amount == 0) return 1;
        if(dp[i][amount] != -1) return dp[i][amount];
        if(amount - coins[i] >= 0){
            return dp[i][amount] = solve(amount - coins[i], coins, dp,i) + solve(amount, coins, dp, i+1);  
        }
        else return dp[i][amount] = solve(amount, coins,dp , i+1);

    }
}
