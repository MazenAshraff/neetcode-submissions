class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length();i++){
            count+=countPalindromes(s,i,i);
            count+=countPalindromes(s,i,i+1);
        }
        return count;
    }

    public int countPalindromes(String s, int i, int j){
        int count = 0;
        for(int n = i,m = j; n >=0 && m <s.length();n--,m++){
            if(s.charAt(n) == s.charAt(m)){
                count++;
            }
            else{
                break;
            }
        }
        return count;
    }
}
