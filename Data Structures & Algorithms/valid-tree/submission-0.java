class Solution {
    public boolean validTree(int n, int[][] edges) {
        boolean [] result = new boolean[]{true};
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length;i++){
            int from  = edges[i][0];
            int to = edges[i][1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        boolean [] vis = new boolean[n];
        dfs(adj, vis, 0, -1,result);
        if(!result[0])
            return result[0];
        for(int i = 0; i < n;i++){
            if(!vis[i]) return false;
        }
        return true; 
    }


    public  void dfs(ArrayList<ArrayList<Integer>> adj, boolean [] vis, int i, int parent,boolean [] result){
        if(vis[i]){
            result[0] = false;
            return;
        }
        vis[i] = true;
        for(int j = 0; j < adj.get(i).size(); j++){
            if(adj.get(i).get(j)!=parent){
                dfs(adj, vis, adj.get(i).get(j), i, result);
            }
        }

    }
}
