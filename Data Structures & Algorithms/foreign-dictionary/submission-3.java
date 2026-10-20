class Solution {
    public String foreignDictionary(String[] words) {
        if(words.length == 1) return words[0];
      HashMap<Character,HashSet<Character>> dic = new HashMap<>();
        for(int i = 0, j = 1; j < words.length;i++,j++){
            boolean broken = false;
            for(int n = 0, m = 0; n < words[i].length() || m < words[j].length(); n++, m++){
                if(!broken){
                    if(m == words[j].length() && n < words[i].length()) return "";
                    if(m < words[j].length() && n == words[i].length()) break;
                    
                    char first = words[i].charAt(n);
                    char second = words[j].charAt(m);
                    if(!dic.containsKey(first)){
                        dic.put(first, new HashSet<>());
                    }
                    if(first!=second){

                        if(!dic.containsKey(second)){
                            dic.put(second, new HashSet<>());
                        }
                        dic.get(first).add(second);
                        broken = true;
                    }
                }
                else{
                    if(n < words[i].length()){
                        dic.put(words[i].charAt(n), dic.getOrDefault(words[i].charAt(n), new HashSet<>()));
                    }
                    if(m < words[j].length()){
                        dic.put(words[j].charAt(m), dic.getOrDefault(words[j].charAt(m), new HashSet<>()));
                    }
                }
            }
        }

        HashMap<Character,Integer> in = new HashMap<>();
        int edges = 0;
        for(Map.Entry<Character, HashSet<Character>> entry : dic.entrySet()){
            for(Character child : entry.getValue()){
                edges++;
                in.put(child, in.getOrDefault(child, 0) + 1);
            }
            in.put(entry.getKey(), in.getOrDefault(entry.getKey(), 0));
        }
        ArrayDeque<Character> dq = new ArrayDeque<>();
        for(Map.Entry<Character,Integer> entry : in.entrySet()){
            if(entry.getValue() == 0){
                dq.add(entry.getKey());
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!dq.isEmpty()){
            Character cur = dq.removeFirst();
            sb.append(cur);
            for(Character child : dic.get(cur)){
                edges--;
                in.put(child, in.get(child) - 1);
                if(in.get(child) == 0){
                    dq.add(child);
                }
            }
        }
        return edges == 0? sb.toString(): "";
    }
}
