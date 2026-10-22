class Solution {
    public String longestPalindrome(String s) {
        int resLen = 1;
        int res = 0;
        for(int i = 0; i < s.length();i++){
            for(int j = i+1, k = i -1;  j <s.length() && k >=0;j++,k--){
                if(s.charAt(j) == s.charAt(k)){
                    int curLen = j - k + 1;
                    if(curLen > resLen){
                        res = k;
                        resLen = curLen;
                    }
                }
                else{
                    break;
                }
            }
            for(int j = i, k = i+1; j >=0 && k < s.length(); j--,k++){
                if(s.charAt(j) == s.charAt(k)){
                    int curLen = k - j + 1;
                    if(curLen > resLen){
                        res = j;
                        resLen = curLen;
                    }    
                }
                else{
                    break;
                }
            }
        }
        return s.substring(res, res+resLen);
    }
}
