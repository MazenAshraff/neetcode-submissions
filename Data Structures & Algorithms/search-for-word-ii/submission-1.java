class Solution {
    public final int [][] dir = new int [][]{{0,1},{1,0},{-1,0},{0,-1}};
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        root.populate(words);
        int n = board.length;
        int m = board[0].length;
        boolean [][] vis = new boolean[n][m];
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m;j++){
                int charIdx = board[i][j] - 'a';
                ans.addAll(dfs(board,vis,i,j, new ArrayList<>(), root.getChild(charIdx)));
                if(ans.size() == words.length){
                    return ans;
                }
            }
        }

        return ans;
        
    }

    public List<String> dfs(char[][] board, boolean [][] vis,int i,int j, List<String> stringsFound, TrieNode cur){
        int charIdx = board[i][j] - 'a';
        if(cur == null) return stringsFound;
        if(vis[i][j]) return stringsFound;
        if(cur.getWord() != null){
            stringsFound.add(cur.getWord());
            cur.setWord(null);
        }
        vis[i][j] = true;
        for(int k = 0; k < 4;k++){
            int newRow = i + dir[k][0];
            int newCol = j + dir[k][1];
            if(validIndex(vis,newRow,newCol)){
                int newCharIdx = board[newRow][newCol] - 'a';
                TrieNode child = cur.getChild(newCharIdx);
                dfs(board, vis,newRow, newCol, stringsFound, child);
            }
        }
        vis[i][j] = false;
        return stringsFound;

    }

    public boolean validIndex(boolean [][] vis, int i, int j){
        return i>=0 && j>=0 && i < vis.length && j < vis[0].length;
    }


    class TrieNode{
        private TrieNode [] children;
        private String word;
        
        public TrieNode(){
            children = new TrieNode[26];
        }
        public String getWord(){
            return word;
        }
        public void setWord(String word){
            this.word = word;
        }

        public TrieNode getOrCreateChild(int i){
            if(children[i] == null){
                return children[i] = new TrieNode();
            }
            return children[i];
        }

        public TrieNode getChild(int i){
            return children[i];
        }

        public TrieNode populate(String [] words){
            for(int i = 0; i < words.length;i++){
                TrieNode cur = this;
                for(int j = 0; j<words[i].length();j++){
                    int charIdx = words[i].charAt(j) - 'a';
                    cur = cur.getOrCreateChild(charIdx);
                }
                cur.setWord(words[i]);
            }
            return this;

        }

    }
}
