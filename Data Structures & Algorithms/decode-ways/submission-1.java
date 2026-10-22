class Solution {
    public int numDecodings(String s) {
        int prev1 = 1;
        int prev2 = 1;
        if (s.charAt(0) == '0')
            return 0;
        for (int i = 1; i < s.length(); i++) {
            int cur = 0;
            if(s.charAt(i)!= '0'){
                cur +=prev1;
            }
            int back = ((s.charAt(i-1) - '0') * 10) + (s.charAt(i) - '0');
            if(back >= 10 && back<= 26){
                cur += prev2;
            }
            if(cur == 0) return 0;
            prev2 = prev1;
            prev1 = cur;
        }

        return prev1;
    }
}
