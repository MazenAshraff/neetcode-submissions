class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][] {newInterval};
        }
        int posStart = location(intervals, newInterval[0]);
        int posEnd = location(intervals, newInterval[1]);
        ArrayList<int[]> arr = new ArrayList<>();
        int loopFrom = 0;
        if (posStart == -1) {
            if (posEnd > -1 && isMerge(newInterval, intervals[posEnd])) {
                newInterval[1] = Math.max(newInterval[1], intervals[posEnd][1]);
                loopFrom = posEnd + 1;
            }
            arr.add(newInterval);
        }
        for (int i = loopFrom; i < intervals.length; i++) {
            if (i != posStart) {
                arr.add(intervals[i]);
            } else {
                if (!isMerge(intervals[i], newInterval)) {
                    arr.add(intervals[i]);
                    if (!isMerge(newInterval, intervals[posEnd])) {
                        arr.add(newInterval);
                    } else {
                        newInterval[0] = Math.min(newInterval[0], intervals[posEnd][0]);
                        newInterval[1] = Math.max(newInterval[1], intervals[posEnd][1]);
                        arr.add(newInterval);
                        i = posEnd;
                    }
                } else {
                    newInterval[0] = Math.min(newInterval[0], intervals[posStart][0]);
                    if (isMerge(newInterval, intervals[posEnd])) {
                        newInterval[1] = Math.max(newInterval[1], intervals[posEnd][1]);
                        i = posEnd;
                    }
                    arr.add(newInterval);
                }
            }
        }
        int[][] newIntervals = new int[arr.size()][2];
        for (int i = 0; i < arr.size(); i++) {
            newIntervals[i] = arr.get(i);
        }
        return newIntervals;
    }
    public boolean isMerge(int[] i1, int[] i2) {
        if (i2[0] < i1[0]) {
            int[] temp = i1;
            i1 = i2;
            i2 = temp;
        }
        return i2[0] >= i1[0] && i2[0] <= i1[1];
    }
    public int location(int[][] intervals, int i) {
        int low = 0;
        int high = intervals.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (intervals[mid][0] <= i) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}
