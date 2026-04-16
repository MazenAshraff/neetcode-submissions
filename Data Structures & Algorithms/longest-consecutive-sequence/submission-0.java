class Solution {
    HashMap<Integer,Integer> sequenceStart = new HashMap<>();
    HashMap<Integer,Integer> sequenceLengths = new HashMap<>();
    public int longestConsecutive(int[] nums) {
        int longestConsecutiveSeq = 0;
        for(int num : nums){
            if(sequenceStart.containsKey(num))
                continue;
            if(!sequenceStart.containsKey(num - 1) && !sequenceStart.containsKey(num + 1)){
                sequenceStart.put(num, num);
                sequenceLengths.put(num, 1);
                longestConsecutiveSeq = Math.max(longestConsecutiveSeq, 1);

            }
            else{
                if(sequenceStart.containsKey(num - 1) && !sequenceStart.containsKey(num + 1)){
                    Integer startKey = getStart(num - 1);
                    sequenceStart.put(num, startKey);
                    Integer newLength = sequenceLengths.get(startKey) + 1;
                    sequenceLengths.put(startKey, newLength);
                    longestConsecutiveSeq = Math.max(newLength, longestConsecutiveSeq);
                }
                else {
                    if(!sequenceStart.containsKey(num - 1) && sequenceStart.containsKey(num + 1)){
                        sequenceStart.put(num+1, num);
                        sequenceStart.put(num, num);
                        Integer newLength = sequenceLengths.get(num + 1) + 1;
                        sequenceLengths.put(num, newLength);
                        sequenceLengths.put(num + 1, null);
                        longestConsecutiveSeq = Math.max(newLength, longestConsecutiveSeq);

                    }
                    else{
                        Integer startKey = getStart(num - 1);
                        sequenceStart.put(num, startKey);
                        sequenceStart.put(num+1, startKey);
                        Integer newLength = sequenceLengths.get(startKey)+ 1 + sequenceLengths.get(num+1);
                        sequenceLengths.put(startKey, newLength);
                        sequenceLengths.put(num+1, null);
                        longestConsecutiveSeq = Math.max(newLength, longestConsecutiveSeq);
                    }
                }
            }
        }
        return longestConsecutiveSeq;
    }

    public Integer getStart(Integer num){
        if (num == sequenceStart.get(num)){
            return num;
        }
        return getStart(sequenceStart.get(num));
    }
}
