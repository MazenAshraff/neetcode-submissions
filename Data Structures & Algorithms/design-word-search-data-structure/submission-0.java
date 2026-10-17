class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for(int i = 0;i< word.length();i++){
            cur = cur.getOrCreateChild(word.charAt(i));
        }
        cur.setWordEnd();
    }

    public boolean search(String word) {
        return searchHelper(word, root, 0);
    }

    private boolean searchHelper(String word, TrieNode cur, int w){
        if(w == word.length()) return cur.isWordEnd();
        boolean ans = false;
        if(word.charAt(w) == '.'){
            for(int i = 0; i < 26;i ++){
                if(cur.getChild(i)!= null){
                    ans |= searchHelper(word, cur.getChild(i), w+1);
                    if(ans) return true;
                }
            }
        }
        else{
            TrieNode child = cur.getChild(word.charAt(w) - 'a');
            if(child != null){
                return searchHelper(word,child, w+1);
            }
        }
        return false;
    }

    static class TrieNode {
        private TrieNode[] children;
        private boolean wordEnd;

        public TrieNode(){
            children = new TrieNode[26];
        }

        public void setWordEnd(){
            wordEnd = true;
        }

        public boolean isWordEnd(){
            return wordEnd;
        }

        public TrieNode getChild(int i){
            return children[i];
        }

        public final TrieNode getOrCreateChild( char c){
            int i = c -'a';
            if(children[i] == null){
                children[i] = new TrieNode();
            }
            return children[i];
        }
    }
}
