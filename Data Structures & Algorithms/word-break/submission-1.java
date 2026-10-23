class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode root = new TrieNode();
        root.populate(wordDict);
        boolean [] dp = new boolean[s.length()];
        for(int i = 0; i < s.length();i++){
            TrieNode cur = root;
            for(int j = i; j <s.length();j++){
                int charIdx = s.charAt(j) - 'a';
                if(cur.getChild(charIdx)!= null && (i == 0 ||dp[i-1])){
                    cur = cur.getChild(charIdx);
                    if(cur.isEnd()) dp[j] = true;
                }
                else{
                    break;
                }
            }
        }
        return dp[s.length() - 1];
    }
    // public boolean isWordPossible(String s, Boolean [] dp, TrieNode cur,int i){
    //     if(i == s.length() && cur.idxInDic!= null) return true;
    //     if(i == s.length()) return false;
    //     if(dp[i] != null) return dp[i];
    //     int charIdx = s.charAt(i) - 'a';
    //     boolean ans = false;
    //     if(cur == cur.root && cur.getChild(charIdx) == null) return dp[i] = false;
    //     if(cur.getChild(charIdx) != null){
    //         ans |= isWordPossible(s,dp, cur.getChild(charIdx), i+1);
    //     }
    //     if(cur.idxInDic != null){
    //         System.out.println("found "+ cur.idxInDic);
    //         ans |= isWordPossible(s,dp,cur.root, i);
    //     }
    //     return dp[i] = ans;
    // }
    static class TrieNode{
        TrieNode [] children;
        TrieNode root;
        boolean end;
        public TrieNode(){
            children = new TrieNode[26];
            root = this;
        }

        public TrieNode getOrCreateChild(int i){
            if(children[i] == null){
                children[i] = new TrieNode();
            }
            return children[i];
        }
        public void setEnd(){
            end = true;
        }
        public boolean isEnd(){
            return end;
        }
        public TrieNode getChild(int i){
            return children[i];
        }
        public void populate(List<String> wordDict){
            for(int i = 0;i < wordDict.size();i++){
                TrieNode cur = this;
                for(int j = 0; j < wordDict.get(i).length();j++){
                    int idx = wordDict.get(i).charAt(j) - 'a';
                    cur = cur.getOrCreateChild(idx);
                }
                cur.setEnd();
            }
        }
    }
}
