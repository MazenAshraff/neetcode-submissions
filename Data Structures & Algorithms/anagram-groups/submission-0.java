class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> dic = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        for(String str : strs){
            String key = getKey(str);
            if(!dic.containsKey(key)){
                dic.put(key, new ArrayList<>());
            }
            dic.get(key).add(str);
        }
        for (Map.Entry<String,List<String>> entry : dic.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }

    public String getKey(String str){
        char [] strAsChars = str.toCharArray();
        Arrays.sort(strAsChars);
        StringBuilder sb = new StringBuilder();
        for(char character : strAsChars){
            sb.append(character);
        }
        return sb.toString();
    }
}
