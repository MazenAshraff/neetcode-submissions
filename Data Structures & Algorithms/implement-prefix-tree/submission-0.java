class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            int curCharIndex = word.charAt(i) - 'a';
            TrieNode [] letters = cur.getLetters();
            if(letters[curCharIndex] == null){
                letters[curCharIndex] = new TrieNode();
            }
            cur = letters[curCharIndex];
        }
        cur.wordEnd = true;

    }

    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0;i < word.length(); i++){
            TrieNode [] letters = cur.getLetters();
            int curCharIndex = word.charAt(i) - 'a';
            if(letters[curCharIndex] == null) return false;
            cur = letters[curCharIndex];
        }
        return cur.isWordEnd();

    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0;i < prefix.length(); i++){
            TrieNode [] letters = cur.getLetters();
            int curCharIndex = prefix.charAt(i) - 'a';
            if(letters[curCharIndex] == null) return false;
            cur = letters[curCharIndex];
        }
        return true;
    }

    class TrieNode{
        private TrieNode [] letter;
        private boolean wordEnd;

        public TrieNode(){
            letter = new TrieNode[26];
            wordEnd = false;
        }
        public TrieNode [] getLetters(){
            return letter;
        }
        public boolean isWordEnd(){
            return wordEnd;
        }
    }
}
