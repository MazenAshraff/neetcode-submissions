class Solution {
    public String minWindow(String s, String t) {
HashMap<Character,Integer> repS = new HashMap<>();
HashMap<Character,Integer> repT = new HashMap<>();
for(int i = 0; i < t.length(); i++){
	repT.put(t.charAt(i), repT.getOrDefault(t.charAt(i),0) + 1);
}
int count = repT.size();
String min = null;
for(int i = 0, j = 0; j< s.length(); j++){
	char c = s.charAt(j);
	repS.put(c, repS.getOrDefault(c, 0) + 1);
	if(repT.containsKey(c) && repS.get(c).equals(repT.get(c))){
		count--;
	
}
if(count == 0){
	while( i <= j ){
		char c2  = s.charAt(i);
		i++;
		repS.put(c2, repS.get(c2) - 1);
		if(repT.containsKey(c2) &&repT.get(c2) > repS.get(c2)){
	count++;
	break;
}
}
if(count == 1){
	if(min == null || ( j - ( i - 1 ) + 1) < min.length() ){
		min = s.substring(i - 1, j+1);
}
}
}
}

return min == null ? "" : min;        
    }
}
