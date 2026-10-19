class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int i = 0; i < edges.length ; i++){
            uf.union(edges[i][0], edges[i][1]);
        }

        return uf.components;
    }
    static class UnionFind{
        private int size[];
        private int parent[];
        private int components;
        public UnionFind(int n){
            size = new int [n];
            components = n;
            Arrays.fill(size, 1);
            parent = new int [n];
            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
        }


        public void union(int i, int j){
            int parentI = find(i);
            int parentJ = find(j);
            if(parentI == parentJ) return;
            if(size[parentI] > size[parentJ]){
                size[parentI]+=size[parentJ];
                parent[parentJ] = parentI;
            }
            else{
                size[parentJ] += size[parentI];
                parent[parentI] = parentJ;
            }
            components--;
        }

        public int find(int i){
            if(parent[i] == i) return i;
            return parent[i] = find(parent[i]); 
        }
    }
}
