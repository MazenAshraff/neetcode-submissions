class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int [][] dp = new int[coins.length][amount+1];
        for(int i = 0; i < coins.length;i++){
            Arrays.fill(dp[i], -2);
        }
        return coins(coins, coins.length - 1, amount, dp);
    }

    public int coins(int [] coins, int i, int amount, int [][] dp){
        if(amount == 0) return 0;
        if(i == -1) return -1;
        if(dp[i][amount]!=-2)return dp[i][amount];
        int curCoins = -1;
        if(coins[i] <= amount){
            curCoins = coins(coins, i, amount - coins[i], dp);
            if(curCoins != -1){
                curCoins+=1;
            }
        }
        int prevCoins = coins(coins, i - 1, amount,dp);

        if(curCoins == -1){
            return dp[i][amount] =  prevCoins;
        }
        else{
            if(prevCoins == -1){
                return dp[i][amount] = curCoins;
            }
            else{
                return dp[i][amount] = Math.min(prevCoins, curCoins);
            }
        }
    }
}
