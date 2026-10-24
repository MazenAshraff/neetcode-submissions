class Solution {
    public int[][] merge(int[][] intervals) {
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b) -> a[0]!=b[0]? a[0] - b[0] : a[1] - b[1]);
        for(int [] interval : intervals){
            pq.add(interval);
        }
        int i = 0;
        ArrayList<int[]> arr = new ArrayList<>();
        arr.add(pq.poll());
        while(!pq.isEmpty()){
            int [] cur = pq.poll();
            if(cur[0] >= arr.get(i)[0] && cur[0] <= arr.get(i)[1]){
                arr.get(i)[1] = Math.max(arr.get(i)[1], cur[1]);
            }
            else{
                arr.add(cur);
                i++;
            }
        }
        int [][] res = new int[arr.size()][2];
        for(i = 0; i < arr.size();i++){
            res[i] = arr.get(i);
        }
        return res;
    }
}
