class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int count = 0;
        int[] cur = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] == cur[0]) {
                cur = intervals[i];
                count++;
            } else {
                if (intervals[i][0] > cur[0] && intervals[i][0] < cur[1]) {
                    count++;
                    if (intervals[i][1] < cur[1]) {
                        cur = intervals[i];
                    }
                } else {
                    cur = intervals[i];
                }
            }
        }

        return count;
    }
}
