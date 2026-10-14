class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int len = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            if(hm.containsKey(s.charAt(i))){
                start = Math.max(hm.get(s.charAt(i)) + 1, start); 
            }
            len = Math.max(len,  i - start + 1);
            hm.put(s.charAt(i), i);
        }
        return len;
    }
}
