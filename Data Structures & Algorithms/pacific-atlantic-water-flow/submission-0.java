class Solution {
    public static final int[][] dir = new int[][] {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] reachPacific = new boolean[n][m];
        boolean[][] reachAtlantic = new boolean[n][m];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i - 1 == -1 || j - 1 == -1) {
                    reachPacific[i][j] = true;
                }
                if (i + 1 == n || j + 1 == m) {
                    reachAtlantic[i][j] = true;
                }

                if (reachPacific[i][j] || reachAtlantic[i][j]) {
                    q.add(i);
                    q.add(j);
                }
            }
        }
        boolean vis[][] = new boolean[n][m];
        while (!q.isEmpty()) {
            int i = q.poll();
            int j = q.poll();
            dfs(heights, vis, i, j, reachAtlantic[i][j], reachPacific[i][j],reachAtlantic,
                reachPacific);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (reachAtlantic[i][j] && reachPacific[i][j]) {
                    ans.add(List.of(i, j));
                }
            }
        }
        return ans;
    }

    public void dfs(int[][] heights, boolean[][] vis, int i, int j, boolean reachAtlantic,
        boolean reachPacific, boolean[][] atlantic, boolean[][] pacific) {
        vis[i][j] = true;
        atlantic[i][j] |= reachAtlantic;
        pacific[i][j] |= reachPacific;
        for (int k = 0; k < 4; k++) {
            int newRow = i + dir[k][0];
            int newCol = j + dir[k][1];
            if (valid(heights, vis, newRow, newCol, i, j)) {
                dfs(heights, vis, newRow, newCol, reachAtlantic, reachPacific, atlantic, pacific);
            }
        }
        vis[i][j] = false;
    }

    public boolean valid(int[][] heights, boolean[][] vis, int i, int j, int oldI, int oldJ) {
        return i >= 0 && j >= 0 && i < vis.length && j < vis[0].length && !vis[i][j]
            && heights[oldI][oldJ] <= heights[i][j];
    }
}
