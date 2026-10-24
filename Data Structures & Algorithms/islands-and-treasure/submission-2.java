class Solution {
    public static final int[][] dir = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public static final int INF = Integer.MAX_VALUE;
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        ArrayDeque<int []> q = new ArrayDeque<>(); 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[]{i,j});
                }
            }
        }


        while(!q.isEmpty()){
            int [] node = q.poll();
            for(int i = 0; i < 4; i++){

                int nr = node[0] + dir[i][0];
                int nc = node[1] + dir[i][1];
                if(nr>=0 && nc>=0 && nr<n && nc < m && grid[nr][nc] == INF){
                    grid[nr][nc] = 1 + grid[node[0]][node[1]];
                    q.add(new int[] {nr,nc});
                }
            }
        }
    }

}
