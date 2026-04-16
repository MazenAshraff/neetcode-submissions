class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean visited [][] = new boolean[n][m];
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    count++;
                    dfs(grid,visited,i,j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, boolean [][]vis, int i, int j){
        vis[i][j] = true;
        if(i+1 < grid.length && grid[i+1][j] == '1' && !vis[i+1][j]){
            dfs(grid, vis,i+1,j);
        }
        if(j+1 < grid[0].length && grid[i][j+1] == '1' && !vis[i][j+1]){
            dfs(grid, vis,i,j+1);
        }
        if(i-1 >=0 && grid[i-1][j] == '1' && !vis[i-1][j]){
            dfs(grid, vis,i-1,j);
        }
        if(j-1 >=0 && grid[i][j-1] == '1' && !vis[i][j - 1]){
            dfs(grid, vis,i,j-1);
        }
    }
}
