class Solution {
    public static final int [][]dir= new int [][]{{0,1},{1,0},{-1,0},{0,-1}}; 
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean [][]vis = new boolean[n][m];
        int count = 0;
        for(int i = 0;i < n;i++){
            for(int j = 0;j < m; j++){
                if(validIdx(i,j,grid,vis)){
                    count++;
                    dfs(grid,vis,i,j);
                }
            }
        }
        return count;
    }

    public void dfs(char [][] grid, boolean [][]vis, int i, int j){
        vis[i][j] = true;
        int n = vis.length;
        int m = vis[0].length;
        for(int k = 0; k < 4;k++){
            int newRow = i + dir[k][0];
            int newCol = j + dir[k][1];
            if(validIdx(newRow, newCol, grid, vis)){
                dfs(grid,vis,newRow,newCol);
            }
        }
    }

    private boolean validIdx(int i, int j, char [][] grid, boolean [][] vis){
        return i>=0 && j>=0 && i<vis.length && j <vis[0].length && !vis[i][j] && grid[i][j] == '1';
    }

}
