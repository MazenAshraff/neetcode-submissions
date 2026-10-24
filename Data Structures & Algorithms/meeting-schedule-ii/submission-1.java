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
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.end - b.end);
        int max = 0;
        for (int i = 0; i < intervals.size(); i++) {
            while (!pq.isEmpty() && intervals.get(i).start >= pq.peek().end) {
                pq.poll();
            }
            pq.add(intervals.get(i));
            max = Math.max(max, pq.size());
        }
        return max;
    }
}
