/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() == 0) return true;
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b)-> a.end - b.end);
        for(int i= 0;i<intervals.size();i++){
            pq.add(intervals.get(i));
        }
        Interval current = pq.poll();
        while(!pq.isEmpty()){
            if(pq.peek().start < current.end)
                return false;
            current = pq.poll();
        }
        return true;

    }
}
