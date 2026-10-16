class MedianFinder {
    PriorityQueue<Integer> pq0;
    PriorityQueue<Integer> pq1;
    public MedianFinder() {
        pq0 = new PriorityQueue<Integer>((a,b)-> b.compareTo(a));
        pq1 = new PriorityQueue<Integer>((a,b) -> a.compareTo(b));
    }
    
    public void addNum(int num) {
        pq0.add(num);
        pq1.add(pq0.poll());
        if(pq1.size()> pq0.size()){
            pq0.add(pq1.poll());
        }
    }
    
    public double findMedian() {
        if((pq0.size() + pq1.size())%2 == 0){
            return (pq0.peek()*1.0 + pq1.peek())/2;
        }
        else{
            if(pq0.size() > pq1.size()){
                return pq0.peek();
            }
            else{
                return pq1.peek();
            }
        }
    }
}
