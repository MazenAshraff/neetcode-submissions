class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> counts = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            counts.put(nums[i],counts.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int []result = new int[k];
        for(Map.Entry entry: counts.entrySet()){
            pq.add(new Pair((int)entry.getKey(), (int)entry.getValue()));
        }
        for(int i = 0; i < k;i++){
            result[i] = pq.poll().a;
        }
        return result;

    }
    class Pair implements Comparable<Pair>{
        int a;
        int b;
        public Pair(int i, int j){
            a = i;
            b = j;
        }
        public int compareTo(Pair o){
            return o.b - b;
        }
    }
}
