class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] in = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i< numCourses;i++){
            adj.add(new ArrayList<>());
        }
        int dep = 0;
        for(int i = 0; i < prerequisites.length; i++){
            in[prerequisites[i][1]]++;
            dep++;
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < numCourses; i++){
            if(in[i] == 0){
                dq.add(i);
            }
        }

        while(!dq.isEmpty()){
            int cur = dq.removeFirst();
            for(int i = 0; i < adj.get(cur).size();i++){
                int child = adj.get(cur).get(i);
                in[child]--;
                dep--;
                if(in[child] == 0){
                    dq.add(child);
                }
            }
        }



        return dep == 0;
    }
}
