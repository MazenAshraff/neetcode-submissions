class MedianFinder {
    PriorityQueue<Integer> []pq;
    int countElements = 0;
    public MedianFinder() {
        pq = new PriorityQueue[2];
        pq[0] = new PriorityQueue<Integer>((a,b)-> b.compareTo(a));
        pq[1] = new PriorityQueue<Integer>((a,b) -> a.compareTo(b));
    }
    
    public void addNum(int num) {
        if(countElements == 0){
            pq[0].add(num);
        }else{
            if(countElements == 1){
                if(num >= pq[0].peek()){
                    pq[1].add(num);
                }
                else{
                    pq[1].add(pq[0].poll());
                    pq[0].add(num);
                }
            }
            else{
                int biggestInLow = pq[0].peek();
                int lowestInHigh = pq[1].peek();
                if(countElements %2 !=0){
                    if(pq[0].size() > pq[1].size()){
                        if(num < biggestInLow){
                            pq[1].add(pq[0].poll());
                            pq[0].add(num);
                        }
                        else{
                            pq[1].add(num);
                        }
                    }
                    else{
                        if(pq[1].size() > pq[0].size()){
                            if(num > lowestInHigh){
                                pq[0].add(pq[1].poll());
                                pq[1].add(num);
                            }
                            else{
                                pq[0].add(num);
                            }
                        }
                       
                    }
                }
                else{
                    if(num > lowestInHigh){
                        pq[1].add(num);
                    }
                    else{
                        pq[0].add(num);
                    }
                }
            }

        }
        countElements++;
    }
    
    public double findMedian() {
        if(countElements%2 == 0){
            return (pq[0].peek()*1.0 + pq[1].peek())/2;
        }
        else{
            if(pq[0].size() > pq[1].size()){
                return pq[0].peek();
            }
            else{
                return pq[1].peek();
            }
        }
    }
}
