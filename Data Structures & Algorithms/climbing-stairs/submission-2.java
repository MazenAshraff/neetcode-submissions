class Solution {
    public int climbStairs(int n) {
        int [] countWays = new int[n+2];
        countWays[1] = 1;
        countWays[2] = 2;
        for(int i = 3; i <= n; i++){
            countWays[i] = countWays[i - 1]+countWays[i - 2];
        }
        return countWays[n];
    }
}
