class Solution {
    int[][] directions = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public boolean exist(char[][] board, String word) {
        int[][] charCount = new int[2][26];

        int n = board.length;
        int m = board[0].length;
        int l = word.length();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (Character.isUpperCase(board[i][j])) {
                    charCount[0][board[i][j] - 'A']++;
                } else {
                    charCount[1][board[i][j] - 'a']++;
                }
            }
        }

        for (int i = 0; i < l; i++) {
            char c = word.charAt(i);
            if (Character.isUpperCase(c)) {
                charCount[0][c - 'A']--;
                if (charCount[0][c - 'A'] < 0) {
                    return false;
                }
            } else {
                charCount[1][c - 'a']--;
                if (charCount[1][c - 'a'] < 0) {
                    return false;
                }
            }
        }

        boolean visited[][] = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                
                boolean dfsResult = dfs(board, visited, i, j, word, 0);
                if (dfsResult)
                    return true;

            }
        }
        return false;
    }

    public boolean dfs(char[][] board, boolean vis[][], int i, int j, String word, int w) {
        if (w == word.length())
            return true;
        if(word.charAt(w) != board[i][j]) return false;
        if( w == word.length() - 1) return true;
        vis[i][j] = true;
        for (int k = 0; k < directions.length; k++) {
            int newRow = i + directions[k][0];
            int newCol = j + directions[k][1];
            if (checkBoundary(newRow, newCol, vis)) {
                boolean ans = dfs(board, vis, newRow, newCol, word, w + 1);
                if (ans)
                    return true;
            }
        }
        vis[i][j] = false;
        return false;
    }

    public boolean checkBoundary(int i, int j, boolean[][] vis) {
        return i >= 0 && j >= 0 && i < vis.length && j < vis[0].length && !vis[i][j];
    }
}
