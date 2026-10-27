class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;
        Arrays.sort(hand);
        List<List<Integer>> groups = new ArrayList<>();
        int numGroups = hand.length / groupSize;
        for (int i = 0; i < numGroups; i++) {
            groups.add(new ArrayList<>());
        }
        int priorityIndex = 0;
        int lastIndexWithHand = -1;
        int lastHand = -1;
        for (int i = 0; i < hand.length; i++) {
            List<Integer> curGroup = groups.get(priorityIndex);
            if (curGroup.isEmpty()) {
                curGroup.add(hand[i]);
                lastIndexWithHand = priorityIndex;
                lastHand = hand[i];
            } else {
                if (hand[i] - curGroup.get(curGroup.size() - 1) == 1) {
                    curGroup.add(hand[i]);
                    lastIndexWithHand = priorityIndex;
                    lastHand = hand[i];
                } else {
                    if (lastIndexWithHand + 1 < numGroups) {
                        List<Integer> nextGroup = groups.get(lastIndexWithHand + 1);
                        if (nextGroup.isEmpty()
                            || hand[i] - nextGroup.get(nextGroup.size() - 1) == 1) {
                            nextGroup.add(hand[i]);
                            lastIndexWithHand++;
                            continue;
                        }
                    }
                    return false;
                }
            }
            if (curGroup.size() == groupSize) {
                priorityIndex++;
            }
        }

        // for (List<Integer> group : groups) {
        //     if (group.size() != groupSize)
        //         return false;
        // }
        return true;
    }
}
