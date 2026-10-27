class Solution {
    public int maxProfit(int[] prices) {
        Map<String,Integer> dp = new HashMap<>();
        return solve(prices,dp, 0, true);
    }

    public int solve(int [] prices, Map<String,Integer> dp,int i, boolean buying){
        if(i >= prices.length) return 0;
        String state = state(i, buying);
        if(dp.containsKey(state)){
            return dp.get(state);
        }
        if(buying)
            dp.put(state, Math.max(-prices[i] + solve(prices, dp,i+1, false), solve(prices,dp,i+1,true)));
        else{
            dp.put(state, Math.max(prices[i] + solve(prices, dp,i+2, true), solve(prices,dp,i+1, false)));
        }
        return dp.get(state);
        }

    public String state(int i , boolean buying){
        return i+" "+buying;
    }
}
