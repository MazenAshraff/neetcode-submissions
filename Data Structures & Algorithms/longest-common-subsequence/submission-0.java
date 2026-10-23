class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int [][] dp = new int[text1.length()][text2.length()];
        for(int i = 0; i < dp.length;i++){
            Arrays.fill(dp[i], -1);
        }
        return dp(text1, text2, dp,0,0);
    }

    public int dp(String s1, String s2, int [][] dp,int i, int j){
        if(i == s1.length() || j == s2.length()) return 0;
        if(dp[i][j]!= -1) return dp[i][j];
        int cur = Math.max(dp(s1,s2, dp,i+1,j), dp(s1,s2,dp,i,j+1));
        if(s1.charAt(i) == s2.charAt(j)){
            cur = Math.max(cur , 1 + dp(s1,s2,dp,i+1,j+1));
        }

        return dp[i][j] = cur;
    }
}
