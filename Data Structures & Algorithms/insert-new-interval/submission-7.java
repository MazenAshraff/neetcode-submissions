class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0, n = intervals.length;
        int start = newInterval[0], end = newInterval[1];

        while (i < n && intervals[i][1] < start) result.add(intervals[i++]);   // before

        while (i < n && intervals[i][0] <= end) {                              // overlapping
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        result.add(new int[] {start, end});

        while (i < n) result.add(intervals[i++]);                              // after

        return result.toArray(new int[0][]);
    }
}